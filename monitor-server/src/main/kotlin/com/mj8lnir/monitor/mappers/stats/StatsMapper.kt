package com.mj8lnir.monitor.mappers.stats

import com.mj8lnir.monitor.dto.stats.StatsDto
import com.mj8lnir.monitor.model.stats.Stats
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class StatsMapper : Converter<Stats, StatsDto> {

    override fun convert(source: Stats): StatsDto {
        return StatsDto(
            source.id,
            source.storage.alias,
            source.storage.name,
            source.type,
            source.timeStart,
            source.timeEnd,
            source.status,
            source.inserted,
            source.updated,
            source.broken,
            source.actualSource,
            source.storage.logo.logoName
        )
    }
}