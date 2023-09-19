package com.mj8lnir.monitor.repository.stats

import com.mj8lnir.monitor.dto.stats.StatsInputFilter
import com.mj8lnir.monitor.model.stats.Stats
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface StatsRepository {
    fun getStats(filters: Collection<StatsInputFilter>, globalFilter: String?, pageable: Pageable): Page<Stats>
}