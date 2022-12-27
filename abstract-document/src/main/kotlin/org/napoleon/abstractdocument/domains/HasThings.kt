package org.napoleon.abstractdocument.domains

import org.napoleon.abstractdocument.Document

interface HasModel : Document {
    fun getModel(): String? = get(Property.MODEL.toString()) as String?
}

interface HasPrice : Document {
    fun getPrice(): String? = get(Property.PRICE.toString())?.toString()
}

interface HasType : Document {
    fun getType(): String? = get(Property.TYPE.toString()) as String?
}

interface HasParts : Document {
    fun getParts(): Sequence<Part> = children(Property.PARTS.toString()) { Part(it) }
}
