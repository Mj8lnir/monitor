package com.mj8lnir.monitor.model.storage

enum class StorageColumn(val fieldName: String) {
    ID(Storage::id.name),
    NAME(Storage::name.name),
    ALIAS(Storage::alias.name),
    SOURCE(Storage::sourceId.name),
    ACCESSORY_ABILITY(Storage::accessoryAbility.name),
    BILLING_ABILITY(Storage::billingAbility.name),
    VOIP_ABILITY(Storage::voipAbility.name),
    BS_ABILITY(Storage::bsAbility.name),
    AVAILABLE(Storage::available.name)
}