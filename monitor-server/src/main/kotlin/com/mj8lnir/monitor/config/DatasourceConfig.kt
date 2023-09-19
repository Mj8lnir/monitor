package com.mj8lnir.monitor.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.hibernate.jpa.HibernatePersistenceProvider
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "entityManagerFactoryBean",
    transactionManagerRef = "platformTransactionManager",
    basePackages = ["com.mj8lnir.monitor"]
)
@ComponentScan("com.mj8lnir.monitor")
class DatasourceConfig(
    @Value("\${app.datasource.server.driver-class-name}") private val driver: String,
    @Value("\${app.datasource.server.url}") private val url: String,
    @Value("\${app.datasource.server.username}") private val username: String,
    @Value("\${app.datasource.server.password}") private val password: String
) {

    @Primary
    @Bean
    fun dataSource(): HikariDataSource {
        val config = HikariConfig()
        config.jdbcUrl = url
        config.username = username
        config.password = password
        config.driverClassName = driver
        return HikariDataSource(config)
    }

    @Primary
    @Bean
    fun getNamedParameterJdbcTemplate(): NamedParameterJdbcOperations {
        return NamedParameterJdbcTemplate(dataSource())
    }

    private fun packagesToScan(): Array<String> {
        return arrayOf("com.mj8lnir.monitor.model")
    }

    private fun hibernateProperties(): Map<String, String> {
        return mapOf(
            "hibernate.dialect" to "org.hibernate.dialect.PostgreSQLDialect",
            "hibernate.hbm2ddl.auto" to "none",
            "hibernate.show_sql" to "false",
            "hibernate.format_sql" to "true",
            "hibernate.use_sql_comments" to "true",
            "hibernate.jdbc.batch_size" to "100",
            "hibernate.jdbc.fetch_size" to "100"
        )
    }

    @Primary
    @Bean
    fun entityManagerFactoryBean(): LocalContainerEntityManagerFactoryBean {
        val factoryBean = LocalContainerEntityManagerFactoryBean()
        factoryBean.setPackagesToScan(*packagesToScan())
        factoryBean.dataSource = dataSource()
        factoryBean.setJpaPropertyMap(hibernateProperties())
        factoryBean.persistenceProvider = HibernatePersistenceProvider()
        factoryBean.jpaVendorAdapter = HibernateJpaVendorAdapter()
        factoryBean.afterPropertiesSet()
        return factoryBean
    }

    @Primary
    @Bean
    fun platformTransactionManager(): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactoryBean().getObject()!!)
    }
}