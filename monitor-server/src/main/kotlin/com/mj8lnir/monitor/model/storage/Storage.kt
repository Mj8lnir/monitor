package com.mj8lnir.monitor.model.storage

import com.mj8lnir.monitor.model.BaseEntity
import com.mj8lnir.monitor.model.StorageLogo
import com.mj8lnir.monitor.model.stats.Stats
import javax.persistence.*

@Entity
@Table(name = "storage", schema = "sorm")
class Storage(

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Int,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "alias", nullable = false, unique = true)
    val alias: String,

    @ManyToOne
    @JoinColumn(name = "logo_id", nullable = false)
    val logo: StorageLogo,

    @Column(name = "source_id", nullable = false, unique = true)
    val sourceId: String,

    @Column(name = "accessory_ability", nullable = false)
    val accessoryAbility: Boolean,

    @Column(name = "billing_ability", nullable = false)
    val billingAbility: Boolean,

    @Column(name = "voip_ability", nullable = false)
    val voipAbility: Boolean,

    @Column(name = "bs_ability", nullable = false)
    val bsAbility: Boolean,

    @Column(name = "available", nullable = false)
    val available: Boolean,

    @OneToMany(mappedBy = "storage")
    val stats: List<Stats> = listOf()

) : BaseEntity<Int>()