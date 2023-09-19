package com.mj8lnir.monitor.config

import com.mj8lnir.monitor.model.storage.Storage
import com.mj8lnir.monitor.model.storage.StorageColumn
import com.mj8lnir.monitor.utils.SpecificationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StorageSpecificationConfig(
    private val storageIdSpecificationProvider: SpecificationProvider<Storage>,
    private val storageNameSpecificationProvider: SpecificationProvider<Storage>,
    private val storageAliasSpecificationProvider: SpecificationProvider<Storage>,
    private val storageSourcesSpecificationProvider: SpecificationProvider<Storage>,
    private val storageAccessoryAbilitySpecificationProvider: SpecificationProvider<Storage>,
    private val storageBillingAbilitySpecificationProvider: SpecificationProvider<Storage>,
    private val storageVoipAbilitySpecificationProvider: SpecificationProvider<Storage>,
    private val storageBsAbilitySpecificationProvider: SpecificationProvider<Storage>,
    private val storageAvailableSpecificationProvider: SpecificationProvider<Storage>
) {

    @Bean
    fun getStorageSpecificationProviderMap(): Map<StorageColumn, SpecificationProvider<Storage>> {
        return mapOf(
            StorageColumn.ID to storageIdSpecificationProvider,
            StorageColumn.NAME to storageNameSpecificationProvider,
            StorageColumn.ALIAS to storageAliasSpecificationProvider,
            StorageColumn.SOURCE to storageSourcesSpecificationProvider,
            StorageColumn.ACCESSORY_ABILITY to storageAccessoryAbilitySpecificationProvider,
            StorageColumn.BILLING_ABILITY to storageBillingAbilitySpecificationProvider,
            StorageColumn.VOIP_ABILITY to storageVoipAbilitySpecificationProvider,
            StorageColumn.BS_ABILITY to storageBsAbilitySpecificationProvider,
            StorageColumn.AVAILABLE to storageAvailableSpecificationProvider
        )
    }
}