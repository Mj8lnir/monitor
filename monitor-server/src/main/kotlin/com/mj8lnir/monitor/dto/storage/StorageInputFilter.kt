package com.mj8lnir.monitor.dto.storage

import com.fasterxml.jackson.annotation.JsonProperty
import com.mj8lnir.monitor.model.storage.StorageColumn

data class StorageInputFilter(
    @JsonProperty("id") val fieldName: StorageColumn,
    @JsonProperty("value") val criteria: String
)