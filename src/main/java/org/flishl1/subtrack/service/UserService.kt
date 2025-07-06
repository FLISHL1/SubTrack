package org.flishl1.subtrack.service;

import org.flishl1.subtrack.model.User
import org.flishl1.subtrack.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.telegram.telegrambots.meta.api.objects.User as UserTg


//fun <S : User?> UserRepository.saveAndFlishUser(entity: S?): S? {
//    return saveAndFlush(entity);
//}


@Service
open class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    open fun createUser(
        userInfo: UserTg
    ): User {
        var user = User(
            firstName = userInfo.firstName,
            lastName = userInfo.lastName,
            telegramChatId = userInfo.id.toString()
        )
        user = userRepository.saveAndFlush(user)
        return user
    }

    @Transactional
    open fun existUser(telegramId: String): Boolean {
        return userRepository.existsByTelegramChatId(telegramId)
    }
}
