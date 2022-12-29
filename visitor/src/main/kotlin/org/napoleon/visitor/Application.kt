package org.napoleon.visitor

import org.napoleon.visitor.domains.*

fun main() {
    val commander = Commander(
        Sergeant(Soldier(), Soldier(), Soldier()),
        Sergeant(Soldier(), Soldier(), Soldier())
    )

    commander.accept(SoldierVisitor())
    commander.accept(SergeantVisitor())
    commander.accept(CommanderVisitor())
}
