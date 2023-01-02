package org.napoleon.balking

import org.napoleon.balking.domains.WashingMachine
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val washingMachine = WashingMachine()
    val executorService: ExecutorService = Executors.newFixedThreadPool(3)
    repeat(times = 3) { executorService.execute(washingMachine::wash) }
    executorService.shutdown()

    if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
        executorService.shutdownNow()
    }
}
