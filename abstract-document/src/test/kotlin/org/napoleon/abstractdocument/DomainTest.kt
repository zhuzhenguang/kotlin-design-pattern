package org.napoleon.abstractdocument

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.napoleon.abstractdocument.domains.Car
import org.napoleon.abstractdocument.domains.Part
import org.napoleon.abstractdocument.domains.Property

class DomainTest {
    @Test
    fun `should construct part`() {
        val partProperties: Map<String, Any> = mapOf(
            Property.TYPE.toString() to "test-part-type",
            Property.MODEL.toString() to "test-part-model",
            Property.PRICE.toString() to "0"
        )

        val part = Part(partProperties)

        assertThat(part.getType()).isEqualTo("test-part-type")
        assertThat(part.getModel()).isEqualTo("test-part-model")
        assertThat(part.getPrice()).isEqualTo("0")
    }

    @Test
    fun `should construct car`() {
        val carProperties: Map<String, Any> = mapOf(
            Property.MODEL.toString() to "test-part-model",
            Property.PRICE.toString() to "8",
            Property.PARTS.toString() to listOf(mapOf<String, Any>(), mapOf())
        )

        val car = Car(carProperties)

        assertThat(car.getModel()).isEqualTo("test-part-model")
        assertThat(car.getPrice()).isEqualTo("8")
        assertThat(car.getParts().count()).isEqualTo(2)
    }
}
