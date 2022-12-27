package org.napoleon.abstractdocument.domains

import org.napoleon.abstractdocument.AbstractDocument

class Part(partProperties: Map<String, Any>) : AbstractDocument(partProperties), HasModel, HasPrice, HasType
