package com.archon.project.service

import com.archon.project.database.UserImpl
import com.archon.project.entity.User
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import java.util.*

class UserServiceImpl: UserService {

    override suspend fun storeById(user: User.Create) = newSuspendedTransaction {
        UserImpl.new(user.uniqueId) {
            coins = user.coins
            points = user.points
        }
    }

    override suspend fun updateById(user: User, update: User.Update) = newSuspendedTransaction {
        user.run {
            coins = update.coins ?: coins
            points = update.coins ?: points
        }
    }

    override suspend fun findById(uniqueId: UUID): User? {
        return UserImpl.findById(uniqueId)
    }

    override suspend fun deleteById(uniqueId: UUID) {
        UserImpl.findById(uniqueId)?.delete()
    }
}