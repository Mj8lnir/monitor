package com.mj8lnir.monitor.repository.storage

import com.mj8lnir.monitor.model.storage.Storage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StorageJpaRepository : JpaRepository<Storage, Int>, JpaSpecificationExecutor<Storage>