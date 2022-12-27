package org.napoleon.activeobject

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.napoleon.activeobject.domains.Orc
import org.napoleon.activeobject.domains.Status

class ActiveObjectTest {
    @Test
    fun `should create orc`() {
        val orc = Orc("tom")

        assertThat(orc)
            .hasFieldOrPropertyWithValue("name", "tom")
            .hasFieldOrPropertyWithValue("status", Status.INIT)
    }
}
