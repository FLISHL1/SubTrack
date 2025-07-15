package org.flishl1.subtrack.model;

import jakarta.persistence.*;
import org.flishl1.subtrack.enums.notification.NotificationChannel;
import org.flishl1.subtrack.enums.notification.NotificationStatus;
import org.flishl1.subtrack.enums.notification.NotificationType;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Notifications")
public class Notification {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    public UUID uuid;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    public User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "subscription_id")
    public Subscription subscription;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "n_type", nullable = false)
    public NotificationType type;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "channel", nullable = false)
    public NotificationChannel channel;
    @Column(name = "scheduled_time", nullable = false)
    public LocalDateTime scheduledTime;
    @Column(name = "sent_time")
    public LocalDateTime sentTime;
    @Enumerated(value = EnumType.STRING)
    @ColumnDefault("'PENDING'")
    @Column(name = "n_status", nullable = false)
    public NotificationStatus status;
    @Column(name = "payload")
    public String payload; //TODO("Проверить какой нужен тип данных")

    public Notification() {
    }
}
