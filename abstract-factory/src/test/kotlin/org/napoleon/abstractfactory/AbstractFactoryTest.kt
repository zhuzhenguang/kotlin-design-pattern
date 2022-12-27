package org.napoleon.abstractfactory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.napoleon.abstractfactory.domains.KingdomType

class AbstractFactoryTest {
    @Test
    fun `verify elf creation`() {
        val (king, castle, army) = Application().createKingdom(KingdomType.ELF)

        assertThat(king.getDescription()).isEqualTo("This is the elven king!")
        assertThat(castle.getDescription()).isEqualTo("This is the elven castle!")
        assertThat(army.getDescription()).isEqualTo("This is the elven army!")
    }

    @Test
    fun `verify orc creation`() {
        val (king, castle, army) = Application().createKingdom(KingdomType.ORC)

        assertThat(king.getDescription()).isEqualTo("This is the orc king!")
        assertThat(castle.getDescription()).isEqualTo("This is the orc castle!")
        assertThat(army.getDescription()).isEqualTo("This is the orc army!")
    }
}
