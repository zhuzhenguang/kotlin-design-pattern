package org.napoleon.visitor

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.napoleon.visitor.domains.*
import org.napoleon.visitor.domains.Unit
import org.slf4j.LoggerFactory
import java.util.*

class VisitorTest {
    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender()
    }

    @AfterEach
    fun tearDown() = appender.stop()

    @Test
    fun `should visit unit`() {
        UnitVisitor().visit(Commander(*children()))

        assertThat(appender.getLastMessage()).isEqualTo("Hello Commander")
        assertThat(appender.getLogSize()).isEqualTo(1)
    }

    @Test
    fun `should visit sergeant`() {
        UnitVisitor().visit(Sergeant(*children()))

        assertThat(appender.getLastMessage()).isEqualTo("Hello Sergeant")
        assertThat(appender.getLogSize()).isEqualTo(1)
    }

    @Test
    fun `should visit soldier`() {
        UnitVisitor().visit(Soldier(*children()))

        assertThat(appender.getLastMessage()).isEqualTo("Good to see you Soldier")
        assertThat(appender.getLogSize()).isEqualTo(1)
    }

    private fun children() = Array<Unit>(5) { Mockito.mock() }
}

class InMemoryAppender : AppenderBase<ILoggingEvent>() {
    private val log: MutableList<ILoggingEvent> = LinkedList()

    init {
        (LoggerFactory.getLogger("UnitVisitor") as Logger).addAppender(this)
        start()
    }

    override fun append(eventObject: ILoggingEvent?) {
        eventObject?.let { log.add(it) }
    }

    fun getLogSize() = log.size

    fun getLastMessage(): String = log.last().formattedMessage
}
