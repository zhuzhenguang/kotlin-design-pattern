package org.napoleon.abstractdocument

abstract class AbstractDocument(propParams: Map<String, Any>) : Document {
    override val properties = HashMap(propParams)
}
