package com.archon.project.entity

import java.util.*

interface User {

    val uniqueId: UUID

    var coins: Int
    var points: Int

    data class Create(
            val uniqueId: UUID,
            val coins: Int,
            val points: Int
    )

    data class Update(
            val coins: Int? = null,
            val points: Int? = null
    )
}