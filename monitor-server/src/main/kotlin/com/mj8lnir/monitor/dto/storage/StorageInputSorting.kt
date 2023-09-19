package com.mj8lnir.monitor.dto.storage

import com.fasterxml.jackson.annotation.JsonProperty
import com.mj8lnir.monitor.model.storage.StorageColumn

data class StorageInputSorting(
    @JsonProperty("id") val fieldName: StorageColumn,
    @JsonProperty("desc") val isDescending: Boolean
)