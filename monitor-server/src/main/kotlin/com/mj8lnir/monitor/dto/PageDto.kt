package com.mj8lnir.monitor.dto

data class PageDto<out T>(
    val content: List<T> = emptyList(),
    val totalRowCount: Long = 0
)