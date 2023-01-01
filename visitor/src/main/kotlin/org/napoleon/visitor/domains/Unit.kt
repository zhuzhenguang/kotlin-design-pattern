package org.napoleon.visitor.domains

interface Unit {
    val children: Array<out Unit>
}

class Sergeant(override vararg val children: Unit) : Unit {
    override fun toString() = "Sergeant"
}

class Soldier(override vararg val children: Unit) : Unit {
    override fun toString() = "Soldier"
}

class Commander(override vararg val children: Unit) : Unit {
    override fun toString() = "Commander"
}

fun Unit.accept(unitVisitor: UnitVisitor) {
    when (this) {
        is Soldier -> unitVisitor.visit(this)
        is Sergeant -> unitVisitor.visit(this)
        is Commander -> unitVisitor.visit(this)
    }
}
