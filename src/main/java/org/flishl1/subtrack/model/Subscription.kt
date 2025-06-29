package org.flishl1.subtrack.model

import jakarta.persistence.*
import org.flishl1.subtrack.enums.BillingCycle
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Generated
import org.hibernate.annotations.NaturalId
import org.hibernate.generator.EventType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity(name = "Subscription")
data class Subscription(
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    val uuid: UUID,
    @NaturalId
    @Column(name = "s_name", nullable = false)
    val name: String,
    @Column(name = "description", columnDefinition = "text")
    val description: String,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "category_id", nullable = false)
    val category: Category,
    @Column(name = "price", nullable = false)
    val price: BigDecimal,
    @Column(name = "currency", nullable = false)
    val currency: String,
    @Column(name = "billingCycle", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val billingCycle: BillingCycle,
    @Column(name = "next_payment_date", nullable = false)
    val nextPaymentDate: LocalDate,
    @Column(name = "is_active", nullable = false)
    val isActive: Boolean,
    @Generated(event = [EventType.INSERT])
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime,
    @Generated(event = [EventType.INSERT, EventType.UPDATE])
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDateTime,
)
