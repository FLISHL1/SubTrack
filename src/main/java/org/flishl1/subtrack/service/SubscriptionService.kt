package org.flishl1.subtrack.service

import org.flishl1.subtrack.repository.SubscriptionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class SubscriptionService(
    private val subscriptionRepository: SubscriptionRepository
) {
    open fun getCountSubscription(userTgId: Long): Long{
        return subscriptionRepository.countSubscriptionsActiveByUserTelegramChatIdEquals(userTgId.toString())
    }
}