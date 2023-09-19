package com.mj8lnir.monitor.mappers.storage

import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.storage.StorageDto
import com.mj8lnir.monitor.model.storage.Storage
import org.springframework.core.convert.converter.Converter
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class StoragePageMapper(private val mapper: Converter<Storage, StorageDto>) : Converter<Page<Storage>, PageDto<StorageDto>> {

    override fun convert(source: Page<Storage>): PageDto<StorageDto> {
        return PageDto(
            source.content.mapNotNull { mapper.convert(it) },
            source.totalElements
        )
    }
}