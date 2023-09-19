package com.mj8lnir.monitor.service.storage

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.mj8lnir.monitor.dto.PageDto
import com.mj8lnir.monitor.dto.storage.StorageDto
import com.mj8lnir.monitor.dto.storage.StorageInputFilter
import com.mj8lnir.monitor.dto.storage.StorageInputSorting
import com.mj8lnir.monitor.mappers.storage.StoragePageMapper
import com.mj8lnir.monitor.model.storage.StorageColumn
import com.mj8lnir.monitor.repository.storage.StorageRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class StorageServiceImpl(
    private val mapper: StoragePageMapper,
    private val repository: StorageRepository,
    private val objectMapper: ObjectMapper
) : StorageService {

    override fun getStorages(
        start: Int,
        size: Int,
        filterString: String,
        globalFilterString: String,
        sortingString: String
    ): PageDto<StorageDto> {
        val filters = try {
            objectMapper.readValue(filterString, object : TypeReference<Set<StorageInputFilter>>() {})
        } catch (e: InvalidFormatException) {
            emptyList()
        }
        val sorting = try {
            objectMapper.readValue(sortingString, object : TypeReference<Set<StorageInputSorting>>() {})
        } catch (e: InvalidFormatException) {
            emptyList()
        }
        val globalFilter = globalFilterString.ifBlank { null }

        val sort: Sort = if (sorting.isEmpty()) {
            Sort.by(Sort.Order.desc(StorageColumn.ID.fieldName))
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

        return mapper.convert(repository.getStorages(filters, globalFilter, pageable))
    }
}