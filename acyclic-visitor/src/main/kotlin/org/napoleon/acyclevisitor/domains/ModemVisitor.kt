package org.napoleon.acyclevisitor.domains

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface HayesVisitor {
    fun visit(hayes: Hayes)
}

interface ZoomVisitor {
    fun visit(zoom: Zoom)
}

private val log: Logger = LoggerFactory.getLogger("ModemVisitor")

open class ConfigureForDosVisitor : HayesVisitor, ZoomVisitor {
    override fun visit(hayes: Hayes) = log.info("{} used with Dos configurator.", hayes)
    override fun visit(zoom: Zoom) = log.info("{} used with Dos configurator.", zoom)
}

open class ConfigureForUnixVisitor : ZoomVisitor {
    override fun visit(zoom: Zoom) = log.info("{} used with Unix configurator.", zoom)
}
