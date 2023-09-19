package com.mj8lnir.monitor.model

import com.mj8lnir.monitor.model.storage.Storage
import javax.persistence.*

@Entity
@Table(name = "storage_logo", schema = "sorm")
class StorageLogo(

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Int,

    @Column(name = "logo_name", nullable = false, unique = true)
    val logoName: String,

    @OneToMany(mappedBy = "logo")
    val storages: List<Storage> = listOf()

) : BaseEntity<Int>()