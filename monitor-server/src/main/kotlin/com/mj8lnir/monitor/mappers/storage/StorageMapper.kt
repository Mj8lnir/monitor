package com.mj8lnir.monitor.mappers.storage

import com.mj8lnir.monitor.dto.storage.StorageDto
import com.mj8lnir.monitor.model.storage.Storage
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class StorageMapper : Converter<Storage, StorageDto> {

    override fun convert(source: Storage): StorageDto? {
        return StorageDto(
            source.name,
            source.alias,
            source.sourceId,
            source.logo.logoName,
            source.accessoryAbility,
            source.billingAbility,
            source.voipAbility,
            source.bsAbility,
            source.available
        )
    }
}