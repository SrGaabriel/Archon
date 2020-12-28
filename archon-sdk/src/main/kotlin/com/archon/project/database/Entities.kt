package com.archon.project.database

import com.archon.project.entity.User
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class UserImpl(id: EntityID<UUID>): UUIDEntity(id), User {
    companion object: UUIDEntityClass<UserImpl>(UserTable)

    override val uniqueId: UUID = id.value
    override var coins: Int by UserTable.coins
    override var points: Int by UserTable.points

}