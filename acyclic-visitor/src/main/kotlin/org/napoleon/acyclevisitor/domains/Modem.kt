package org.napoleon.acyclevisitor.domains

class Zoom {
    fun accept(zoomVisitor: ZoomVisitor) = zoomVisitor.visit(this)
    override fun toString() = "Zoom Modem"
}

class Hayes {
    fun accept(hayesVisitor: HayesVisitor) = hayesVisitor.visit(this)
    override fun toString() = "Hayes Modem"
}
