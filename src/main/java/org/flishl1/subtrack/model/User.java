package org.flishl1.subtrack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.NaturalId;
import org.hibernate.generator.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Users")
public class User {
    @Id
    @Generated
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid")
    public UUID uuid = null;
    @NaturalId
    @Column(name = "email", nullable = true, length = 255)
    public String email = null;
    @Column(name = "first_name", length = 255)
    public String firstName;
    @Column(name = "last_name", length = 255)
    public String lastName;
    @Column(name = "password", nullable = true, length = 255)
    public String password = null;
    @Column(name = "telegram_chat_id", unique = true)
    public String telegramChatId;
    @Generated(event = EventType.INSERT)
    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    public LocalDateTime createdAt = null;
    @Generated(event = {EventType.INSERT, EventType.UPDATE})
    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    public LocalDateTime updatedAt = null;

    private User(Builder builder) {
        this.uuid = builder.uuid;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.telegramChatId = builder.telegramChatId;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public User() {
    }

    public static class Builder {
        private UUID uuid;
        private String email;
        private String firstName;
        private String lastName;
        private String password;
        private String telegramChatId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public Builder() {
        }

        public Builder uuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder telegramChatId(String telegramChatId) {
            this.telegramChatId = telegramChatId;
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

        public User build() {
            return new User(this);
        }
    }

}
