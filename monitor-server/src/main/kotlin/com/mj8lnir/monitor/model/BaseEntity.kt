package com.mj8lnir.monitor.model

import java.io.Serializable
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseEntity<T : Serializable> {

    abstract val id: T

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != other.javaClass) return false

        other as BaseEntity<*>

        return this.id == other.id
    }

    override fun hashCode(): Int {
        return 1
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}{id=${id}}"
    }
}