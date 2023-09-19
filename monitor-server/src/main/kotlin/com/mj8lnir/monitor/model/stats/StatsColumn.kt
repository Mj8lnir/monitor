package com.mj8lnir.monitor.model.stats

import com.mj8lnir.monitor.model.storage.Storage

enum class StatsColumn(val fieldName: String) {
    ID(Stats::id.name),
    TASK_PREFIX(Storage::alias.name),
    TASK_TYPE(Stats::type.name),
    TIME_START(Stats::timeStart.name),
    TIME_END(Stats::timeEnd.name),
    TASK_STATUS(Stats::status.name),
    INSERTED(Stats::inserted.name),
    UPDATED(Stats::updated.name),
    BROKEN(Stats::broken.name),
    STORAGE_ID(Stats::actualSource.name)
}