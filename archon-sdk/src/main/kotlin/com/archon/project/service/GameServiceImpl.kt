package com.archon.project.service

import com.archon.project.entity.Kit
import java.util.*

class GameServiceImpl: GameService {
    private val userCurrentKits = hashMapOf<UUID, Kit>()

    override fun getUserCurrentKit(uniqueId: UUID): Kit? {
        return userCurrentKits[uniqueId]
    }

    override fun setUserCurrentKit(uniqueId: UUID, kit: Kit?) {
        userCurrentKits[uniqueId] = kit ?: return
    }
}