AlTER TABLE Users
    ALTER COLUMN password drop not null;

AlTER TABLE Users
    ALTER COLUMN email drop not null;

ALTER TABLE users
    ADD CONSTRAINT uc_users_telegram_chat_id UNIQUE (telegram_chat_id);