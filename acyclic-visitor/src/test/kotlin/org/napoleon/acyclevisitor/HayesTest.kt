package org.napoleon.acyclevisitor

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.napoleon.acyclevisitor.domains.ConfigureForDosVisitor
import org.napoleon.acyclevisitor.domains.Hayes

class HayesTest {
    @Test
    fun `should accept for dos`() {
        val hayes = Hayes()
        val mockVisitor: ConfigureForDosVisitor = mock()

        hayes.accept(mockVisitor)

        verify(mockVisitor).visit(hayes)
    }
}
