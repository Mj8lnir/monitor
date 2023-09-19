package com.mj8lnir.monitor.repository.stats

import com.mj8lnir.monitor.dto.stats.StatsInputFilter
import com.mj8lnir.monitor.model.stats.Stats
import com.mj8lnir.monitor.model.stats.StatsColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Repository

@Repository
class StatsRepositoryImpl(
    private val repository: StatsJpaRepository,
    private val specMap: Map<StatsColumn, SpecificationProvider<Stats>>
) : StatsRepository {

    override fun getStats(filters: Collection<StatsInputFilter>, globalFilter: String?, pageable: Pageable): Page<Stats> {
        var specification: Specification<Stats> = if (globalFilter == null) {
            Specification.where(null)
        } else {
            Specification
                .where(specMap[StatsColumn.TASK_PREFIX]!!.getSpec(globalFilter))
                .or(specMap[StatsColumn.TASK_TYPE]!!.getSpec(globalFilter))
                .or(specMap[StatsColumn.TASK_STATUS]!!.getSpec(globalFilter))
                .or(specMap[StatsColumn.STORAGE_ID]!!.getSpec(globalFilter))
        }
        for (filter in filters) {
            specification = Specification
                .where(specification)
                .and(specMap[filter.fieldName]?.getSpec(filter.criteria))
        }
        return repository.findAll(specification, pageable)
    }
}