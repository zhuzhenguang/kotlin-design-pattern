package org.napoleon.activeobject

import org.napoleon.activeobject.domains.Orc

class Application : Runnable {
    override fun run() {
        val activities = listOf(
            Orc("Orc-0"),
            Orc("Orc-1"),
            Orc("Orc-2")
        )

        activities.forEach {
            it.eat()
            it.roam()
        }

        activities.forEach(Orc::kill)
    }
}

fun main() {
    Application().run()
}
