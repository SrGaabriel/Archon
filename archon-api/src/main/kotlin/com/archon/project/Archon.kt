package com.archon.project

import com.archon.project.service.GameService
import com.archon.project.service.UserService

interface ArchonService {

    val userService: UserService
    val gameService: GameService

}