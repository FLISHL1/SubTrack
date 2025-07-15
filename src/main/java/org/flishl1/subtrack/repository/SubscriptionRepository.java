package org.flishl1.subtrack.repository;

import org.flishl1.subtrack.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    Long countSubscriptionsActiveByUserTelegramChatIdEquals(String userTelegramChatId);
}
