package com.archon.project.util.extension

import com.archon.project.entity.User
import com.archon.project.util.getArchonPlugin
import org.bukkit.entity.Player

private val userService = getArchonPlugin().archonService.userService

suspend fun User.update(update: User.Update.() -> Unit): User = apply {
    userService.updateById(this, User.Update().apply(update))
}

suspend fun Player.asUser(): User =
        getArchonPlugin().archonService.userService.findById(uniqueId)