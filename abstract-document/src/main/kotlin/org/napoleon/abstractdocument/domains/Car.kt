package org.napoleon.abstractdocument.domains

import org.napoleon.abstractdocument.AbstractDocument

class Car(carProperties: Map<String, Any>) : AbstractDocument(carProperties), HasParts, HasPrice, HasModel
