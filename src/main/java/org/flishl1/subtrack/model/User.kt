package org.flishl1.subtrack.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Generated
import org.hibernate.annotations.NaturalId
import org.hibernate.generator.EventType
import java.time.LocalDateTime
import java.util.*

@Entity(name = "Users")
data class User(
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    val uuid: UUID? = null,
    @NaturalId
    @Column(name = "email", nullable = true, length = 255)
    val email: String? = null,
    @Column(name = "first_name", length = 255)
    val firstName: String?,
    @Column(name = "last_name", length = 255)
    val lastName: String?,
    @Column(name = "password", nullable = true, length = 255)
    val password: String? = null,
    @Column(name = "telegram_chat_id", unique = true)
    val telegramChatId: String?,
    @Generated(event = [EventType.INSERT])
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime? = null,
    @Generated(event = [EventType.INSERT, EventType.UPDATE])
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime? = null,
)