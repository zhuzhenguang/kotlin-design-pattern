package org.napoleon.visitor.domains

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface UnitVisitor {
    fun visit(soldier: Soldier)
    fun visit(sergeant: Sergeant)
    fun visit(commander: Commander)
}

private val log: Logger = LoggerFactory.getLogger("UnitVisitor")

class SoldierVisitor : UnitVisitor {
    override fun visit(soldier: Soldier) = log.info("Good to see you {}", soldier)
    override fun visit(sergeant: Sergeant) = Unit
    override fun visit(commander: Commander) = Unit
}

class SergeantVisitor : UnitVisitor {
    override fun visit(soldier: Soldier) = Unit
    override fun visit(sergeant: Sergeant) = log.info("Hello {}", sergeant)
    override fun visit(commander: Commander) = Unit
}

class CommanderVisitor : UnitVisitor {
    override fun visit(soldier: Soldier) = Unit
    override fun visit(sergeant: Sergeant) = Unit
    override fun visit(commander: Commander) = log.info("Hello {}", commander)
}
