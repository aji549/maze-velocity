package com.aji.mazevelocity.model

/**
 * Data class representing a vehicle or character that can be unlocked by the player.
 */
data class UnlockableVehicle(
    val iconResId: Int,
    val name: String,
    val unlockDesc: String,
    val unlocked: Boolean = false
)