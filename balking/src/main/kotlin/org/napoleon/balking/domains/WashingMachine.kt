package org.napoleon.balking.domains

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

private val log: Logger = LoggerFactory.getLogger("WashingMachine")

class WashingMachine(private val delayProvider: DelayProvider) {
    private var state = WashingMachineState.ENABLED

    constructor() : this({ _: Long, _: TimeUnit, task: Runnable -> task.run() })

    fun wash() {
        synchronized(this) {
            log.info("{}: Actual machine state: {}", Thread.currentThread().name, state)
            if (state == WashingMachineState.WASHING) {
                log.error("Cannot wash if the machine has been already washing!")
                return
            }
            state = WashingMachineState.WASHING
        }
        log.info("{}: Doing the washing", Thread.currentThread().name)
        delayProvider.executeAfterDelay(50, TimeUnit.MILLISECONDS) { endOfWashing() }
    }

    fun state() = state

    @Synchronized
    private fun endOfWashing() {
        state = WashingMachineState.ENABLED
        log.info("{}: Washing completed.", Thread.currentThread().id)
    }
}

enum class WashingMachineState {
    ENABLED, WASHING
}

fun interface DelayProvider {
    fun executeAfterDelay(interval: Long, timeUnit: TimeUnit, task: Runnable)
}
