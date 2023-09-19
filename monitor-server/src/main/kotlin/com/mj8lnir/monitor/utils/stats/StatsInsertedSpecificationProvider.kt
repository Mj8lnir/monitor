package com.mj8lnir.monitor.utils.stats

import com.mj8lnir.monitor.model.stats.Stats
import com.mj8lnir.monitor.model.stats.StatsColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root

@Component
class StatsInsertedSpecificationProvider : SpecificationProvider<Stats> {

    override fun getSpec(input: String): Specification<Stats> {
        val number = try {
            input.toInt()
        } catch (e: Exception) {
            return Specification.where(null)
        }
        return Specification { root: Root<Stats>, _: CriteriaQuery<*>?, builder: CriteriaBuilder ->
            builder.equal(root.get<Int>(StatsColumn.INSERTED.fieldName), number)
        }
    }
}