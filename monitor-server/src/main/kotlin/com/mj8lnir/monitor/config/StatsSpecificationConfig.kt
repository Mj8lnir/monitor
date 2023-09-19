package com.mj8lnir.monitor.config

import com.mj8lnir.monitor.model.stats.Stats
import com.mj8lnir.monitor.model.stats.StatsColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StatsSpecificationConfig(
    private val statsIdSpecificationProvider: SpecificationProvider<Stats>,
    private val statsPrefixSpecificationProvider: SpecificationProvider<Stats>,
    private val statsTypeSpecificationProvider: SpecificationProvider<Stats>,
    private val statsTimeStartSpecificationProvider: SpecificationProvider<Stats>,
    private val statsTimeEndSpecificationProvider: SpecificationProvider<Stats>,
    private val statsStatusSpecificationProvider: SpecificationProvider<Stats>,
    private val statsInsertedSpecificationProvider: SpecificationProvider<Stats>,
    private val statsUpdatedSpecificationProvider: SpecificationProvider<Stats>,
    private val statsBrokenSpecificationProvider: SpecificationProvider<Stats>,
    private val statsStorageSpecificationProvider: SpecificationProvider<Stats>
) {

    @Bean
    fun getStatsSpecificationProviderMap(): Map<StatsColumn, SpecificationProvider<Stats>> {
        return mapOf(
            StatsColumn.ID to statsIdSpecificationProvider,
            StatsColumn.TASK_PREFIX to statsPrefixSpecificationProvider,
            StatsColumn.TASK_TYPE to statsTypeSpecificationProvider,
            StatsColumn.TIME_START to statsTimeStartSpecificationProvider,
            StatsColumn.TIME_END to statsTimeEndSpecificationProvider,
            StatsColumn.TASK_STATUS to statsStatusSpecificationProvider,
            StatsColumn.INSERTED to statsInsertedSpecificationProvider,
            StatsColumn.UPDATED to statsUpdatedSpecificationProvider,
            StatsColumn.BROKEN to statsBrokenSpecificationProvider,
            StatsColumn.STORAGE_ID to statsStorageSpecificationProvider
        )
    }
}