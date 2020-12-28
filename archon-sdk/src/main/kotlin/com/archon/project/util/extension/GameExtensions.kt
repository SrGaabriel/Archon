package com.archon.project.util.extension

import com.archon.project.entity.Kit
import com.archon.project.entity.User
import com.archon.project.service.GameService
import com.archon.project.util.getArchonPlugin

private val gameService: GameService = getArchonPlugin().archonService.gameService

var User.currentKit: Kit?
    get() = gameService.getUserCurrentKit(uniqueId)
    set(value) = gameService.setUserCurrentKit(uniqueId, value)