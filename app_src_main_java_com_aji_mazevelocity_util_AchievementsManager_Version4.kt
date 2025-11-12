package com.aji.mazevelocity.util

import android.content.Context

class AchievementsManager(private val context: Context, private val progressManager: ProgressManager) {
    fun onChaseWin() {
        progressManager.unlock("vehicle_chase")
    }
    fun onPursuitWin() {
        progressManager.unlock("vehicle_pursuit")
    }
    fun onLevelReached(level: Int) {
        if (level >= 10) progressManager.unlock("vehicle_sport")
    }
}