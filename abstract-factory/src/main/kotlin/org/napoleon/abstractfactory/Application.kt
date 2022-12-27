package org.napoleon.abstractfactory

import org.napoleon.abstractfactory.domains.Kingdom
import org.napoleon.abstractfactory.domains.KingdomFactory
import org.napoleon.abstractfactory.domains.KingdomType
import org.napoleon.abstractfactory.domains.makeFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory

private val log: Logger = LoggerFactory.getLogger("Application")

class Application : Runnable {
    override fun run() {
        log.info("elf kingdom")
        val (elfKing, elfCastle, elfArmy) = createKingdom(KingdomType.ELF)
        log.info(elfKing.getDescription())
        log.info(elfCastle.getDescription())
        log.info(elfArmy.getDescription())

        log.info("orc kingdom")
        val (orcKing, orcCastle, orcArmy) = createKingdom(KingdomType.ORC)
        log.info(orcKing.getDescription())
        log.info(orcCastle.getDescription())
        log.info(orcArmy.getDescription())
    }

    fun createKingdom(kingdomType: KingdomType): Kingdom {
        val kingdomFactory: KingdomFactory = makeFactory(kingdomType)
        return Kingdom(kingdomFactory.createKing(), kingdomFactory.createCastle(), kingdomFactory.createArmy())
    }
}

fun main() {
    Application().run()
}
