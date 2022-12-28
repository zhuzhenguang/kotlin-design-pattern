package org.napoleon.acyclevisitor.domains

fun interface Modem {
    fun accept(modemVisitor: ModemVisitor)
}

class Zoom : Modem {
    override fun accept(modemVisitor: ModemVisitor) {
        if (modemVisitor is ZoomVisitor) {
            modemVisitor.visit(this)
        }
    }

    override fun toString() = "Zoom Modem"
}

class Hayes : Modem {
    override fun accept(modemVisitor: ModemVisitor) {
        if (modemVisitor is HayesVisitor) {
            modemVisitor.visit(this)
        }
    }

    override fun toString() = "Hayes Modem"
}
