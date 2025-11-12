package com.aji.mazevelocity.model

data class UnlockableVehicle(
    val id: String,
    val drawableId: Int,
    val name: String,
    val description: String,
    val unlocked: Boolean = false,
    val unlockRequirement: UnlockRequirement
)

sealed class UnlockRequirement {
    object ByDefault : UnlockRequirement()
    data class ByLevel(val level: Int) : UnlockRequirement()
    data class ByAchievement(val achievementId: String) : UnlockRequirement()
    data class ByScore(val score: Int) : UnlockRequirement()
}