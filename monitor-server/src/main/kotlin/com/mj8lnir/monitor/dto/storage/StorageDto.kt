package com.mj8lnir.monitor.dto.storage

import com.fasterxml.jackson.annotation.JsonProperty

data class StorageDto(

    @get: JsonProperty("name")
    val name: String,

    @get: JsonProperty("alias")
    val alias: String,

    @get: JsonProperty("source_ids")
    val sourceId: String,

    @get: JsonProperty("logo_name")
    val logoName: String,

    @get: JsonProperty("accessory_ability")
    val accessoryAbility: Boolean,

    @get: JsonProperty("billing_ability")
    val billingAbility: Boolean,

    @get: JsonProperty("voip_ability")
    val voipAbility: Boolean,

    @get: JsonProperty("bs_ability")
    val bsAbility: Boolean,

    @get: JsonProperty("availability")
    val availability: Boolean
)