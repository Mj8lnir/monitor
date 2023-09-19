package com.mj8lnir.monitor.dto.stats

import com.fasterxml.jackson.annotation.JsonProperty
import com.mj8lnir.monitor.model.stats.StatsColumn

data class StatsInputFilter(
    @JsonProperty("id") val fieldName: StatsColumn,
    @JsonProperty("value") val criteria: String
)