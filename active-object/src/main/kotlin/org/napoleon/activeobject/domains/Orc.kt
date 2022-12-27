package org.napoleon.activeobject.domains

import org.napoleon.activeobject.ActiveCreature
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val log: Logger = LoggerFactory.getLogger("Orc")

class Orc(name: String) : ActiveCreature(name) {
    fun eat() = act(Status.EATING) {
        log.info("{} is eating!", name())
        log.info("{} has finished eating!", name())
    }

    fun roam() = act(Status.ROAM) {
        log.info("{} is roaming!", name())
        log.info("{} has finished roaming!", name())
    }

    fun kill() = act(Status.DEAD) {
        log.info("{} is dead!", name())
        log.info("{} has finished killing!", name())
    }
}

enum class Status {
    EATING, ROAM, DEAD, INIT
}
