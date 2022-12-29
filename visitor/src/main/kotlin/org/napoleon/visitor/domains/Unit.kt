package org.napoleon.visitor.domains

interface Unit {
    val children: Array<out Unit>
    fun accept(unitVisitor: UnitVisitor) {
        children.forEach { it.accept(unitVisitor) }
    }
}

class Sergeant(override vararg val children: Unit) : Unit {
    override fun accept(unitVisitor: UnitVisitor) {
        unitVisitor.visit(this)
        super.accept(unitVisitor)
    }

    override fun toString() = "Sergeant"
}

class Soldier(override vararg val children: Unit) : Unit {
    override fun accept(unitVisitor: UnitVisitor) {
        unitVisitor.visit(this)
        super.accept(unitVisitor)
    }

    override fun toString() = "Soldier"
}

class Commander(override vararg val children: Unit) : Unit {
    override fun accept(unitVisitor: UnitVisitor) {
        unitVisitor.visit(this)
        super.accept(unitVisitor)
    }

    override fun toString() = "Commander"
}
