package com.archon.project.service

import com.archon.project.entity.Kit
import java.util.*

interface GameService {

    fun getUserCurrentKit(uniqueId: UUID): Kit?

    fun setUserCurrentKit(uniqueId: UUID, kit: Kit?)

}