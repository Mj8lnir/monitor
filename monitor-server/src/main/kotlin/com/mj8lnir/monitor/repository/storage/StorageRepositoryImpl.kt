package com.mj8lnir.monitor.repository.storage

import com.mj8lnir.monitor.dto.storage.StorageInputFilter
import com.mj8lnir.monitor.model.storage.Storage
import com.mj8lnir.monitor.model.storage.StorageColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Repository

@Repository
class StorageRepositoryImpl(
    private val repository: StorageJpaRepository,
    private val specMap: Map<StorageColumn, SpecificationProvider<Storage>>
) : StorageRepository {

    override fun getStorages(
        filters: Collection<StorageInputFilter>,
        globalFilter: String?,
        pageable: Pageable
    ): Page<Storage> {
        var specification: Specification<Storage> = if (globalFilter == null) {
            Specification.where(null)
        } else {
            Specification
                .where(specMap[StorageColumn.NAME]!!.getSpec(globalFilter))
                .or(specMap[StorageColumn.ALIAS]!!.getSpec(globalFilter))
                .or(specMap[StorageColumn.SOURCE]!!.getSpec(globalFilter))
        }
        for (filter in filters) {
            specification = Specification
                .where(specification)
                .and(specMap[filter.fieldName]?.getSpec(filter.criteria))
        }
        return repository.findAll(specification, pageable)
    }
}