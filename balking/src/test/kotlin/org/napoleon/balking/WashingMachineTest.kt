package org.napoleon.balking

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.napoleon.balking.domains.DelayProvider
import org.napoleon.balking.domains.WashingMachine
import org.napoleon.balking.domains.WashingMachineState
import java.util.concurrent.TimeUnit

class WashingMachineTest {
    @Test
    fun `should wash`() {
        val washingMachine = WashingMachine(FakeDelayProvider())

        washingMachine.wash()
        washingMachine.wash()

        assertThat(washingMachine.state()).isEqualTo(WashingMachineState.WASHING)
    }

    @Test
    fun `should finish wash by delay provider`() {
        val delayProvider = FakeDelayProvider()
        val washingMachine = WashingMachine(delayProvider)

        washingMachine.wash()
        delayProvider.processTask()

        assertThat(washingMachine.state()).isEqualTo(WashingMachineState.ENABLED)
    }

    @Test
    fun `should end wash`() {
        val washingMachine = WashingMachine()

        washingMachine.wash()

        assertThat(washingMachine.state()).isEqualTo(WashingMachineState.ENABLED)
    }


}

class FakeDelayProvider : DelayProvider {
    private lateinit var task: Runnable

    override fun executeAfterDelay(interval: Long, timeUnit: TimeUnit, task: Runnable) {
        this.task = task
    }

    fun processTask() = task.run()
}
