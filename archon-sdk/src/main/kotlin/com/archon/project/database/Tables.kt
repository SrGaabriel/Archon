package com.archon.project.database

import org.jetbrains.exposed.dao.id.UUIDTable

object UserTable: UUIDTable("userTable", columnName = "uuid") {

    val coins = integer("coins")
    val points = integer("points")

}