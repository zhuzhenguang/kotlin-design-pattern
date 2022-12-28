package org.napoleon.acyclevisitor

import org.napoleon.acyclevisitor.domains.*

fun main() {
    val visitors: List<ModemVisitor> = listOf(ConfigureForDosVisitor(), ConfigureForUnixVisitor())
    val modems: List<Modem> = listOf(Hayes(), Zoom())

    run(visitors, modems)
}

fun run(visitors: List<ModemVisitor>, modems: List<Modem>) =
    modems.forEach { modem -> visitors.forEach(modem::accept) }
