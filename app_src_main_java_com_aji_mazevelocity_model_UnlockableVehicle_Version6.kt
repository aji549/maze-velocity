package com.aji.mazevelocity.model

/**
 * Data class for vehicles that can be unlocked and selected by the player.
 */
data class UnlockableVehicle(
    val iconResId: Int,
    val name: String,
    val unlockDesc: String,
    var unlocked: Boolean = false
)