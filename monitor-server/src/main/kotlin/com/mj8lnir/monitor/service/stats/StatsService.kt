package com.mj8lnir.monitor.service.stats

import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.stats.StatsDto

interface StatsService {
    fun getStats(
        start: Int,
        size: Int,
        filterString: String,
        globalFilterString: String,
        sortingString: String
    ): PageDto<StatsDto>
}