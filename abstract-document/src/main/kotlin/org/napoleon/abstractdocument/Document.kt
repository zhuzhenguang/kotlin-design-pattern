package org.napoleon.abstractdocument

interface Document {
    val properties: MutableMap<String, Any?>

    fun put(key: String, value: Any) {
        properties[key] = value
    }

    fun get(key: String): Any? = properties[key]

    fun <T> children(key: String, constructor: (Map<String, Any>) -> T): Sequence<T> =
        sequenceOf(get(key))
            .filterNotNull()
            .filterIsInstance<List<Map<String, Any>>>()
            .flatMap { it }
            .map(constructor)
}
