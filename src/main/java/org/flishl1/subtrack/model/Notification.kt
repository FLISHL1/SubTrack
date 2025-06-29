package org.flishl1.subtrack.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.PrimaryKeyJoinColumn
import org.flishl1.subtrack.enums.notification.NotificationChannel
import org.flishl1.subtrack.enums.notification.NotificationStatus
import org.flishl1.subtrack.enums.notification.NotificationType
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Generated
import org.hibernate.annotations.NaturalId
import java.time.LocalDateTime
import java.util.*

@Entity(name = "Notifications")
data class Notification(
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    val uuid: UUID,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "subscription_id")
    val subscription: Subscription,
    @Enumerated(value = EnumType.STRING)
    @Column(name = "n_type", nullable = false)
    val type: NotificationType,
    @Enumerated(value = EnumType.STRING)
    @Column(name = "channel", nullable = false)
    val channel: NotificationChannel,
    @Column(name = "scheduled_time", nullable = false)
    val scheduledTime: LocalDateTime,
    @Column(name = "sent_time")
    val sentTime: LocalDateTime,
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'PENDING'")
    @Column(name = "n_status", nullable = false)
    val status: NotificationStatus,
    @Column(name = "payload")
    val payload: String //TODO("Проверить какой нужен тип данных")
)
