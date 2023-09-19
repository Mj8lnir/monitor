package com.mj8lnir.monitor.utils.stats

import com.mj8lnir.monitor.model.stats.Stats
import com.mj8lnir.monitor.model.storage.Storage
import com.mj8lnir.monitor.model.storage.StorageColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Component
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Join
import javax.persistence.criteria.Root

@Component
class StatsPrefixSpecificationProvider : SpecificationProvider<Stats> {

    override fun getSpec(input: String): Specification<Stats> {
        return Specification { root: Root<Stats>, _: CriteriaQuery<*>?, builder: CriteriaBuilder ->
            val statsStorage: Join<Storage, Stats> = root.join("storage")
            builder.like(builder.lower(statsStorage[StorageColumn.ALIAS.fieldName]), "%${input.lowercase()}%")
        }
    }
}