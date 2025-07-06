package org.flishl1.subtrack.repository;

import org.flishl1.subtrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User getByTelegramChatId(String telegramChatId);

    Boolean existsByTelegramChatId(String telegramChatId);
}
