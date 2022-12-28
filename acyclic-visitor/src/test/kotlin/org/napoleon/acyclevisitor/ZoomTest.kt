package org.napoleon.acyclevisitor

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.napoleon.acyclevisitor.domains.ConfigureForDosVisitor
import org.napoleon.acyclevisitor.domains.ConfigureForUnixVisitor
import org.napoleon.acyclevisitor.domains.Zoom

class ZoomTest {
    @Test
    fun `should accept dos`() {
        val zoom = Zoom()
        val mockVisitor: ConfigureForDosVisitor = mock()

        zoom.accept(mockVisitor)

        verify(mockVisitor).visit(zoom)
    }

    @Test
    fun `should accept unix`() {
        val zoom = Zoom()
        val mockVisitor: ConfigureForUnixVisitor = mock()

        zoom.accept(mockVisitor)

        verify(mockVisitor).visit(zoom)
    }
}
