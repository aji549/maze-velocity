package com.aji.mazevelocity.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Utility class to handle saving/loading/resetting game progress.
 */
class ProgressManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("maze_progress", Context.MODE_PRIVATE)

    /**
     * Save current level and unlocked vehicles.
     */
    fun saveProgress(level: Int, unlockedVehicles: Set<String>) {
        prefs.edit()
            .putInt("current_level", level)
            .putStringSet("unlocked_vehicles", unlockedVehicles)
            .apply()
    }

    /**
     * Load saved level or return 1.
     */
    fun getLevel(): Int = prefs.getInt("current_level", 1)

    /**
     * Load unlocked vehicles.
     */
    fun getUnlockedVehicles(): Set<String> = prefs.getStringSet("unlocked_vehicles", emptySet()) ?: emptySet()

    /**
     * Reset all user progress.
     */
    fun resetProgress() {
        prefs.edit().clear().apply()
    }
}