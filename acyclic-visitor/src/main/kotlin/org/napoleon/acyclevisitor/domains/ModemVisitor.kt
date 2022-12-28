package org.napoleon.acyclevisitor.domains

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface ModemVisitor

interface HayesVisitor : ModemVisitor {
    fun visit(modem: Hayes)
}

interface ZoomVisitor : ModemVisitor {
    fun visit(modem: Zoom)
}

private val log: Logger = LoggerFactory.getLogger("ModemVisitor")

open class ConfigureForDosVisitor : HayesVisitor, ZoomVisitor {
    override fun visit(modem: Hayes) = log.info("{} used with Dos configurator.", modem)
    override fun visit(modem: Zoom) = log.info("{} used with Dos configurator.", modem)
}

open class ConfigureForUnixVisitor : ZoomVisitor {
    override fun visit(modem: Zoom) = log.info("{} used with Unix configurator.", modem)
}
