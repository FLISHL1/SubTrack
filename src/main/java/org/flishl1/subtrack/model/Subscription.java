package org.flishl1.subtrack.model;

import jakarta.persistence.*;
import org.flishl1.subtrack.enums.BillingCycle;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.NaturalId;
import org.hibernate.generator.EventType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Subscription")
public class Subscription {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    public UUID uuid;
    @NaturalId
    @Column(name = "s_name", nullable = false)
    public String name;
    @Column(name = "description", columnDefinition = "text")
    public String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    public User user;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id", nullable = false)
    public Category category;
    @Column(name = "price", nullable = false)
    public BigDecimal price;
    @Column(name = "currency", nullable = false)
    public String currency;
    @Column(name = "billingCycle", nullable = false)
    @Enumerated(value = EnumType.STRING)
    public BillingCycle billingCycle;
    @Column(name = "next_payment_date", nullable = false)
    public LocalDate nextPaymentDate;
    @Column(name = "is_active", nullable = false)
    public Boolean isActive;
    @Generated(event = EventType.INSERT)
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    public LocalDateTime updatedAt;

    public Subscription() {
    }

    private Subscription(Builder builder) {
        this.uuid = builder.uuid;
        this.name = builder.name;
        this.description = builder.description;
        this.user = builder.user;
        this.category = builder.category;
        this.price = builder.price;
        this.currency = builder.currency;
        this.billingCycle = builder.billingCycle;
        this.nextPaymentDate = builder.nextPaymentDate;
        this.isActive = builder.isActive;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static class Builder {
        private UUID uuid;
        private String name;
        private String description;
        private User user;
        private Category category;
        private BigDecimal price;
        private String currency;
        private BillingCycle billingCycle;
        private LocalDate nextPaymentDate;
        private Boolean isActive;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder() {
        }

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder billingCycle(BillingCycle billingCycle) {
            this.billingCycle = billingCycle;
            return this;
        }

        public Builder nextPaymentDate(LocalDate nextPaymentDate) {
            this.nextPaymentDate = nextPaymentDate;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Subscription build() {
            if (name == null || user == null || category == null ||
                    price == null || currency == null || billingCycle == null ||
                    nextPaymentDate == null || isActive == null) {
                throw new IllegalStateException("Не все обязательные поля установлены");
            }
            return new Subscription(this);
        }
    }
}
