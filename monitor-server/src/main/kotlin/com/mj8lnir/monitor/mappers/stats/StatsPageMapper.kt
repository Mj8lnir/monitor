package com.mj8lnir.monitor.mappers.stats

import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.model.stats.Stats
import com.mj8lnir.monitor.dto.stats.StatsDto
import org.springframework.core.convert.converter.Converter
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class StatsPageMapper(private val mapper: Converter<Stats, StatsDto>) : Converter<Page<Stats>, PageDto<StatsDto>> {

    override fun convert(source: Page<Stats>): PageDto<StatsDto> {
        return PageDto(
            source.content.mapNotNull { mapper.convert(it) },
            source.totalElements
        )
    }
}