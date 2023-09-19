package com.mj8lnir.monitor.dto.stats

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.time.LocalDateTime

data class StatsDto(

    @get: JsonProperty("id")
    val id: Int,

    @get: JsonProperty("task_prefix")
    val prefix: String,

    @get: JsonProperty("provider_name")
    val provider: String,

    @get: JsonProperty("task_type")
    val type: String,

    @get: JsonSerialize(using = LocalDateTimeSerializer::class)
    @get: JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSS")
    @get: JsonProperty("time_start")
    val timeStart: LocalDateTime,

    @get: JsonSerialize(using = LocalDateTimeSerializer::class)
    @get: JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss.SSS")
    @get: JsonProperty("time_end")
    val timeEnd: LocalDateTime?,

    @get: JsonProperty("task_status")
    val status: String,

    @get: JsonProperty("inserted")
    val inserted: Int,

    @get: JsonProperty("updated")
    val updated: Int,

    @get: JsonProperty("broken")
    val broken: Int,

    @get: JsonProperty("storage")
    val storageId: String,

    @get: JsonProperty("logo_name")
    val logoName: String
)