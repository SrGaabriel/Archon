package com.archon.project

import com.archon.project.util.ArchonVanillaService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.bukkit.plugin.ServicePriority
import org.bukkit.plugin.java.JavaPlugin
import kotlin.coroutines.CoroutineContext

class ArchonPlugin: JavaPlugin(), CoroutineScope {
    val archonService: ArchonService = ArchonVanillaService()
    override val coroutineContext: CoroutineContext = Dispatchers.Default

    override fun onEnable() {
        server.servicesManager.register(ArchonService::class.java, archonService, this, ServicePriority.Normal)
    }

    override fun onDisable() {
    }
}