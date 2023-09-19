package com.mj8lnir.monitor.web

import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.storage.StorageDto
import com.mj8lnir.monitor.service.storage.StorageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/storages")
class StorageWebController(private val service: StorageService) {

    @CrossOrigin(origins = ["*"])
    @GetMapping
    fun getStats(
        @RequestParam(required = false) start: Int = 0,
        @RequestParam(required = false) size: Int = 25,
        @RequestParam(required = false) globalFilter: String = "",
        @RequestParam(required = false) filters: String = "[]",
        @RequestParam(required = false) sorting: String = "[]"
    ): PageDto<StorageDto> {
        return service.getStorages(start, size, filters, globalFilter, sorting)
    }
}