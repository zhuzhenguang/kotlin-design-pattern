package org.napoleon.visitor.domains

import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val log: Logger = LoggerFactory.getLogger("UnitVisitor")

open class UnitVisitor {
    fun visit(soldier: Soldier) {
        log.info("Good to see you {}", soldier)
        visit(soldier.children)
    }

    fun visit(sergeant: Sergeant) {
        log.info("Hello {}", sergeant)
        visit(sergeant.children)
    }

    fun visit(commander: Commander) {
        log.info("Hello {}", commander)
        visit(commander.children)
    }

    private fun visit(children: Array<out Unit>) = children.forEach { it.accept(this) }
}
