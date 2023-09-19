package com.mj8lnir.monitor.model.stats

import com.mj8lnir.monitor.model.BaseEntity
import com.mj8lnir.monitor.model.storage.Storage
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "stats", schema = "sorm")
class Stats(

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val id: Int,

    @Column(name = "task_type", nullable = false, length = 10)
    val type: String,

    @Column(name = "time_start", nullable = false, columnDefinition = "TIMESTAMP")
    val timeStart: LocalDateTime,

    @Column(name = "time_end", columnDefinition = "TIMESTAMP")
    val timeEnd: LocalDateTime?,

    @Column(name = "task_status", nullable = false, length = 30)
    val status: String,

    @Column(nullable = false)
    val inserted: Int,

    @Column(nullable = false)
    val updated: Int,

    @Column(nullable = false)
    val broken: Int,

    @Column(name = "actual_source_id", nullable = false)
    val actualSource: String,

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    val storage: Storage

): BaseEntity<Int>()