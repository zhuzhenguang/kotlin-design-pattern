package org.napoleon.acyclevisitor

import org.napoleon.acyclevisitor.domains.ConfigureForDosVisitor
import org.napoleon.acyclevisitor.domains.ConfigureForUnixVisitor
import org.napoleon.acyclevisitor.domains.Hayes
import org.napoleon.acyclevisitor.domains.Zoom

fun main() {
    val dosVisitor = ConfigureForDosVisitor()
    val unixVisitor = ConfigureForUnixVisitor()

    val hayes = Hayes()
    val zoom = Zoom()

    hayes.accept(dosVisitor)
    zoom.accept(dosVisitor)
    zoom.accept(unixVisitor)
}
