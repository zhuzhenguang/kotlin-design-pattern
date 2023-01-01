package org.napoleon.visitor

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.napoleon.visitor.domains.*
import org.napoleon.visitor.domains.Unit

interface UnitTest<U : Unit> {
    val factory: (Array<Unit>) -> U

    @Test
    fun `unit should accept visitor`() {
        val children = Array<Unit>(5) { mock() }
        val unit: U = factory(children)
        val mockedVisitor = mock<UnitVisitor>()

        unit.accept(mockedVisitor)

        verifyVisit(unit, mockedVisitor)
        verifyNoMoreInteractions(mockedVisitor)
    }

    fun verifyVisit(unit: U, mockedVisitor: UnitVisitor)
}

class SoldierTest : UnitTest<Soldier> {
    override val factory = { children: Array<Unit> -> Soldier(*children) }
    override fun verifyVisit(unit: Soldier, mockedVisitor: UnitVisitor) = verify(mockedVisitor).visit(unit)
}

class SergeantTest : UnitTest<Sergeant> {
    override val factory = { children: Array<Unit> -> Sergeant(*children) }
    override fun verifyVisit(unit: Sergeant, mockedVisitor: UnitVisitor) = verify(mockedVisitor).visit(unit)
}

class CommanderTest : UnitTest<Commander> {
    override val factory = { children: Array<Unit> -> Commander(*children) }
    override fun verifyVisit(unit: Commander, mockedVisitor: UnitVisitor) = verify(mockedVisitor).visit(unit)
}
