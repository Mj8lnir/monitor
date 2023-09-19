package com.mj8lnir.monitor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MonitorServerApplication

fun main(args: Array<String>) {
    runApplication<MonitorServerApplication>(*args)
}
