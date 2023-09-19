package com.mj8lnir.monitor.dto.stats

import com.fasterxml.jackson.annotation.JsonProperty
import com.mj8lnir.monitor.model.stats.StatsColumn

data class StatsInputSorting(
    @JsonProperty("id") val fieldName: StatsColumn,
    @JsonProperty("desc") val isDescending: Boolean
)