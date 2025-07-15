package org.flishl1.subtrack.service;

import org.flishl1.subtrack.model.User
import org.flishl1.subtrack.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.telegram.telegrambots.meta.api.objects.User as UserTg


@Service
@Transactional
open class UserService(
    private val userRepository: UserRepository
) {
    open fun createUser(
        userInfo: UserTg
    ): User {
        var user = User.Builder()
            .firstName(userInfo.firstName)
            .lastName(userInfo.lastName)
            .telegramChatId(userInfo.id.toString())
            .build();
        user = userRepository.saveAndFlush(user)
        return user
    }

    open fun getUser(
        userTgId: Long
    ): User {
        val user: User = userRepository.getByTelegramChatId(userTgId.toString())
        return user
    }

    open fun existUser(telegramId: Long): Boolean {
        return userRepository.existsByTelegramChatId(telegramId.toString())
    }
}
