package com.archon.project.util

import com.archon.project.ArchonPlugin
import com.archon.project.ArchonService
import com.archon.project.service.GameService
import com.archon.project.service.GameServiceImpl
import com.archon.project.service.UserService
import com.archon.project.service.UserServiceImpl
import org.bukkit.plugin.java.JavaPlugin

class ArchonVanillaService: ArchonService {

    override val userService: UserService = UserServiceImpl()
    override val gameService: GameService = GameServiceImpl()

}

fun getArchonPlugin(): ArchonPlugin =
        JavaPlugin.getPlugin(ArchonPlugin::class.java)