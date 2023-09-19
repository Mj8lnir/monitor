package com.mj8lnir.monitor.service.stats

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.stats.StatsDto
import com.mj8lnir.monitor.dto.stats.StatsInputFilter
import com.mj8lnir.monitor.dto.stats.StatsInputSorting
import com.mj8lnir.monitor.mappers.stats.StatsPageMapper
import com.mj8lnir.monitor.model.stats.StatsColumn
import com.mj8lnir.monitor.repository.stats.StatsRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class StatsServiceImpl(
    private val mapper: StatsPageMapper,
    private val repository: StatsRepository,
    private val objectMapper: ObjectMapper
) : StatsService {

    override fun getStats(
        start: Int,
        size: Int,
        filterString: String,
        globalFilterString: String,
        sortingString: String
    ): PageDto<StatsDto> {
        val filters = try {
            objectMapper.readValue(filterString, object : TypeReference<Set<StatsInputFilter>>() {})
        } catch (e: InvalidFormatException) {
            emptyList()
        }
        val sorting = try {
            objectMapper.readValue(sortingString, object : TypeReference<Set<StatsInputSorting>>() {})
        } catch (e: InvalidFormatException) {
            emptyList()
        }
        val globalFilter = globalFilterString.ifBlank { null }

        val sort: Sort = if (sorting.isEmpty()) {
            Sort.by(Sort.Order.desc(StatsColumn.ID.fieldName))
        } else {
            Sort.by(
                sorting
                    .map {
                        if (it.isDescending) Sort.Order.desc(it.fieldName.fieldName)
                        else Sort.Order.asc(it.fieldName.fieldName)
                    }.toList()
            )
        }
        val pageable = PageRequest.of(start, size, sort)

        return mapper.convert(repository.getStats(filters, globalFilter, pageable))
    }
}