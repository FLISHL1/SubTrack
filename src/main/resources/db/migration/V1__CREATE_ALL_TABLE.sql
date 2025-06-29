CREATE TABLE categories
(
    uuid            UUID    DEFAULT gen_random_uuid() NOT NULL,
    c_name          VARCHAR(255)                      NOT NULL,
    icon            VARCHAR(255),
    is_user_defined BOOLEAN DEFAULT FALSE             NOT NULL,
    user_id       UUID,
    CONSTRAINT pk_categories PRIMARY KEY (uuid)
);

CREATE TABLE notifications
(
    uuid              UUID         DEFAULT gen_random_uuid() NOT NULL,
    user_id         UUID                                   NOT NULL,
    subscription_id UUID,
    n_type            VARCHAR(255)                           NOT NULL,
    channel           VARCHAR(255)                           NOT NULL,
    scheduled_time    TIMESTAMP WITHOUT TIME ZONE            NOT NULL,
    sent_time         TIMESTAMP WITHOUT TIME ZONE,
    n_status          VARCHAR(255) DEFAULT 'PENDING'         NOT NULL,
    payload           VARCHAR(255),
    CONSTRAINT pk_notifications PRIMARY KEY (uuid)
);

CREATE TABLE subscription
(
    uuid              UUID DEFAULT gen_random_uuid() NOT NULL,
    s_name            VARCHAR(255)                   NOT NULL,
    description       TEXT,
    user_id         UUID                           NOT NULL,
    category_id     UUID                           NOT NULL,
    price             DECIMAL                        NOT NULL,
    currency          VARCHAR(255)                   NOT NULL,
    billing_cycle     VARCHAR(255)                   NOT NULL,
    next_payment_date date                           NOT NULL,
    is_active         BOOLEAN                        NOT NULL,
    created_at        TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()             NOT NULL,
    updated_at        TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()             NOT NULL,
    CONSTRAINT pk_subscription PRIMARY KEY (uuid)
);

CREATE TABLE users
(
    uuid             UUID DEFAULT gen_random_uuid() NOT NULL,
    email            VARCHAR(255)                   NOT NULL,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    password         VARCHAR(255)                   NOT NULL,
    telegram_chat_id VARCHAR(255),
    created_at       TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()             NOT NULL,
    updated_at       TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()             NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (uuid)
);

ALTER TABLE categories
    ADD CONSTRAINT uc_categories_c_name UNIQUE (c_name);

ALTER TABLE subscription
    ADD CONSTRAINT uc_subscription_s_name UNIQUE (s_name);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE categories
    ADD CONSTRAINT FK_CATEGORIES_ON_USER_UUID FOREIGN KEY (user_id) REFERENCES users (uuid) ON DELETE CASCADE;

ALTER TABLE notifications
    ADD CONSTRAINT FK_NOTIFICATIONS_ON_SUBSCRIPTION_UUID FOREIGN KEY (subscription_id) REFERENCES subscription (uuid);

ALTER TABLE notifications
    ADD CONSTRAINT FK_NOTIFICATIONS_ON_USER_UUID FOREIGN KEY (user_id) REFERENCES users (uuid) ON DELETE CASCADE;

ALTER TABLE subscription
    ADD CONSTRAINT FK_SUBSCRIPTION_ON_CATEGORY_UUID FOREIGN KEY (category_id) REFERENCES categories (uuid);

ALTER TABLE subscription
    ADD CONSTRAINT FK_SUBSCRIPTION_ON_USER_UUID FOREIGN KEY (user_id) REFERENCES users (uuid) ON DELETE CASCADE;

INSERT INTO categories (c_name, icon) VALUES
                                        ('Streaming', 'play-circle'),
                                        ('Software', 'cpu'),
                                        ('Gaming', 'joystick'),
                                        ('Cloud', 'cloud'),
                                        ('Utilities', 'tool');