package org.napoleon.visitor

import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.AppenderBase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.napoleon.visitor.domains.*
import org.slf4j.LoggerFactory
import java.util.*

abstract class VisitorTest {
    protected lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender()
    }

    @AfterEach
    fun tearDown() = appender.stop()
}

class CommanderVisitorTest : VisitorTest() {
    @Test
    fun `should visit commander`() {
        CommanderVisitor().visit(Commander())

        assertThat(appender.getLastMessage()).isEqualTo("Hello Commander")
        assertThat(appender.getLogSize()).isEqualTo(1)
    }
}

class SoldierVisitorTest : VisitorTest() {
    @Test
    fun `should visit soldier`() {
        SoldierVisitor().visit(Soldier())

        assertThat(appender.getLastMessage()).isEqualTo("Good to see you Soldier")
        assertThat(appender.getLogSize()).isEqualTo(1)
    }
}

class SergeantVisitorTest : VisitorTest() {
    @Test
    fun `should visit soldier`() {
        SergeantVisitor().visit(Sergeant())

        assertThat(appender.getLastMessage()).isEqualTo("Hello Sergeant")
        assertThat(appender.getLogSize()).isEqualTo(1)
    }
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
