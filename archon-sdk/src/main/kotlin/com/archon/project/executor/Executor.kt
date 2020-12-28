@file:Suppress("EXPERIMENTAL_API_USAGE")

package com.archon.project.executor

import br.com.devsrsouza.kotlinbukkitapi.flow.eventFlow
import com.archon.project.entity.Kit
import com.archon.project.util.getArchonPlugin
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.bukkit.entity.Player
import org.bukkit.event.Event
import org.bukkit.event.entity.EntityEvent
import org.bukkit.event.player.PlayerEvent

inline fun <reified T : Event> Kit.addListener(noinline callback: suspend T.() -> Unit) =
        eventFlow(T::class, getArchonPlugin(), ignoreCancelled = true)
                .filter {
                    filterEventIntegrity(it, this@addListener)
                }
                .onEach(callback)
                .launchIn(getArchonPlugin())

fun filterEventIntegrity(event: Event, kit: Kit): Boolean {
    val gameService = getArchonPlugin().archonService.gameService

    return when (event) {
        is EntityEvent -> event.entity is Player &&
                gameService.getUserCurrentKit(event.entity.uniqueId) == kit
        is PlayerEvent ->
                gameService.getUserCurrentKit(event.player.uniqueId) == kit
        else -> false
    }
}