package org.napoleon.abstractdocument

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AbstractDocumentTest {
    @Test
    fun `should put and get value`() {
        val document = DocumentImpl(mapOf())

        document.put("key", "value")

        assertThat(document.get("key")).isEqualTo("value")
    }

    @Test
    fun `should retrieve children`() {
        val rootDocument = DocumentImpl(
            mapOf(
                "persons" to listOf(
                    mapOf(
                        "001" to listOf(mapOf<String, Any>("age" to 10, "name" to "tom")),
                        "002" to listOf(mapOf<String, Any>("age" to 20, "name" to "jerry"))
                    )
                )
            )
        )

        val childrenSequence = rootDocument.children("persons") { DocumentImpl(it) }

        assertThat(childrenSequence).isNotNull
        assertThat(childrenSequence.count()).isEqualTo(1)
        val person001 = childrenSequence.single().children("001") { DocumentImpl(it) }
        assertThat(person001.count()).isEqualTo(1)
        assertThat(person001.single().get("age")).isEqualTo(10)
        assertThat(person001.single().get("name")).isEqualTo("tom")
        val person002 = childrenSequence.single().children("002") { DocumentImpl(it) }
        assertThat(person002.count()).isEqualTo(1)
        assertThat(person002.single().get("age")).isEqualTo(20)
        assertThat(person002.single().get("name")).isEqualTo("jerry")
    }

    @Test
    fun `should get empty for none exist key`() {
        val document = DocumentImpl(mapOf())

        val value = document.get("key")

        assertThat(value).isNull()
    }

    @Test
    fun `should retrieve empty for none exist children`() {
        val document = DocumentImpl(mapOf())

        val childrenSequence = document.children("key") { DocumentImpl(it) }

        assertThat(childrenSequence).isNotNull.isInstanceOfSatisfying(Sequence::class.java) {
            assertThat(it.count()).isEqualTo(0)
        }
    }
}

class DocumentImpl(properties: Map<String, Any>) : AbstractDocument(properties)
