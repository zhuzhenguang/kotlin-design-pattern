package org.napoleon.abstractdocument

import org.napoleon.abstractdocument.domains.Car
import org.napoleon.abstractdocument.domains.Property
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val log: Logger = LoggerFactory.getLogger("main")

fun main() {
    log.info("Constructing parts and car")

    val wheelProperties: Map<String, Any> = mapOf(
        Property.TYPE.toString() to "wheel",
        Property.MODEL.toString() to "15C",
        Property.PRICE.toString() to 100L
    )
    val doorProperties: Map<String, Any> = mapOf(
        Property.TYPE.toString() to "door",
        Property.MODEL.toString() to "Lambo",
        Property.PRICE.toString() to 300L
    )
    val carProperties: Map<String, Any> = mapOf(
        Property.MODEL.toString() to "300SL",
        Property.PRICE.toString() to 10000L,
        Property.PARTS.toString() to listOf(wheelProperties, doorProperties)
    )

    val car = Car(carProperties)

    log.info("Here is our car:")
    log.info("-> model: {}", car.getModel())
    log.info("-> price: {}", car.getPrice())
    log.info("-> parts: ")
    car.getParts().forEach {
        log.info("\t{}/{}/{}", it.getType(), it.getModel(), it.getPrice())
    }
}
