package com.mj8lnir.monitor.utils

import org.springframework.data.jpa.domain.Specification

interface SpecificationProvider<T> {
    fun getSpec(input: String): Specification<T>
}