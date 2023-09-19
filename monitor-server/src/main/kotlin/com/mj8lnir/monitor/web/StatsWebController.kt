package com.mj8lnir.monitor.web

import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.stats.StatsDto
import com.mj8lnir.monitor.service.stats.StatsService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/stats")
class StatsWebController(private val service: StatsService) {

    @CrossOrigin(origins = ["*"])
    @GetMapping
    fun getStats(
        @RequestParam(required = false) start: Int = 0,
        @RequestParam(required = false) size: Int = 25,
        @RequestParam(required = false) globalFilter: String = "",
        @RequestParam(required = false) filters: String = "[]",
        @RequestParam(required = false) sorting: String = "[]"
    ): PageDto<StatsDto> {
        return service.getStats(start, size, filters, globalFilter, sorting)
    }
}