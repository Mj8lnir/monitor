package com.mj8lnir.monitor.service.storage

import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.storage.StorageDto

interface StorageService {

    fun getStorages(
        start: Int,
        size: Int,
        filterString: String,
        globalFilterString: String,
        sortingString: String
    ): PageDto<StorageDto>
}