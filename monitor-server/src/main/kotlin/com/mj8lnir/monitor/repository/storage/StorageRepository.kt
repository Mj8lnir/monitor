package com.mj8lnir.monitor.repository.storage

import com.mj8lnir.monitor.dto.storage.StorageInputFilter
import com.mj8lnir.monitor.model.storage.Storage
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface StorageRepository {
    fun getStorages(filters: Collection<StorageInputFilter>, globalFilter: String?, pageable: Pageable): Page<Storage>
}