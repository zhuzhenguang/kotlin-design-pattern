package org.napoleon.acyclevisitor

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.napoleon.acyclevisitor.domains.Modem
import org.napoleon.acyclevisitor.domains.ModemVisitor
import org.napoleon.acyclevisitor.domains.ZoomVisitor

class AppTest {
    @Test
    fun `should loop visit Visitors`() {
        val modem = XModem()
        val visited = mock<XModemVisitor>()
        val nonVisited = mock<ZoomVisitor>()
        val visitors: List<ModemVisitor> = listOf(visited, nonVisited)
        val modems: List<Modem> = listOf(modem)

        modems.forEach { m -> visitors.forEach { m.accept(it) } }

        verify(visited).visit(modem)
        verifyNoMoreInteractions(nonVisited)
    }
}

fun interface XModemVisitor : ModemVisitor {
    fun visit(xModem: XModem)
}

class XModem : Modem {
    override fun accept(modemVisitor: ModemVisitor) {
        if (modemVisitor is XModemVisitor) {
            modemVisitor.visit(this)
        }
    }
}
