package com.archon.project.entity

import org.bukkit.Material

interface Kit {

    val name: String
    val description: String
    val price: Int
    val icon: Material

}