package org.napoleon.abstractfactory.domains

import org.napoleon.abstractfactory.domains.KingdomType.ELF
import org.napoleon.abstractfactory.domains.KingdomType.ORC

fun makeFactory(kingdomType: KingdomType) = when (kingdomType) {
    ELF -> ElfKingdomFactory()
    ORC -> OrcKingdomFactory()
}

class ElfKingdomFactory : KingdomFactory {
    override fun createKing() = King { "This is the elven king!" }

    override fun createCastle() = Castle { "This is the elven castle!" }

    override fun createArmy() = Army { "This is the elven army!" }
}

class OrcKingdomFactory : KingdomFactory {
    override fun createKing() = King { "This is the orc king!" }

    override fun createCastle() = Castle { "This is the orc castle!" }

    override fun createArmy() = Army { "This is the orc army!" }
}

enum class KingdomType {
    ELF, ORC
}
