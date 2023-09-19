package com.mj8lnir.monitor.utils.stats

import com.mj8lnir.monitor.model.stats.Stats
import com.mj8lnir.monitor.model.stats.StatsColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Component
class StatsTimeStartSpecificationProvider : SpecificationProvider<Stats> {

    companion object {
        private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS")
    }

    override fun getSpec(input: String): Specification<Stats> {
        val timestamp = try {
            LocalDateTime.parse(input, formatter)
        } catch (e: Exception) {
            return Specification.where(null)
        }
        return Specification { root: Root<Stats>, _: CriteriaQuery<*>?, builder: CriteriaBuilder ->
            builder.equal(root.get<LocalDateTime>(StatsColumn.TIME_START.fieldName), timestamp)
        }
    }
}