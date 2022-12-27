package org.napoleon.abstractfactory.domains

interface KingdomFactory {
    fun createKing(): King
    fun createCastle(): Castle
    fun createArmy(): Army
}

fun interface King {
    fun getDescription(): String
}

fun interface Castle {
    fun getDescription(): String
}

fun interface Army {
    fun getDescription(): String
}

data class Kingdom(val king: King, val castle: Castle, val army: Army)
