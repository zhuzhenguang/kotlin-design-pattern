package org.napoleon.activeobject

import org.napoleon.activeobject.domains.Status
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

private val log: Logger = LoggerFactory.getLogger("ActiveCreature")

abstract class ActiveCreature(private val name: String) {
    private val requests: BlockingQueue<Runnable> = LinkedBlockingQueue()
    private var status: Status = Status.INIT
    private val thread: Thread = Thread {
        while (true) {
            try {
                requests.take().run()
            } catch (e: InterruptedException) {
                log.warn("this is terminated")
                break
            }
        }
    }

    init {
        thread.start()
    }

    fun act(status: Status, action: () -> Unit) = requests.put {
        this.status = status
        action()
        if (this.status == Status.DEAD) {
            terminate()
        }
    }

    fun name() = this.name

    private fun terminate() = thread.interrupt()
}
