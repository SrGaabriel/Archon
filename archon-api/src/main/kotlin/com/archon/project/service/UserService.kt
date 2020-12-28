package com.archon.project.service

import com.archon.project.entity.User
import java.util.*

interface UserService {

    suspend fun storeById(user: User.Create): User

    suspend fun updateById(user: User, update: User.Update)

    suspend fun findById(uniqueId: UUID): User?

    suspend fun deleteById(uniqueId: UUID)

}