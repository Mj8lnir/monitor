package com.mj8lnir.monitor.repository.stats

import com.mj8lnir.monitor.model.stats.Stats
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

interface StatsJpaRepository : PagingAndSortingRepository<Stats, Int>, JpaSpecificationExecutor<Stats>