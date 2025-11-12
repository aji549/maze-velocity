package com.aji.mazevelocity.util

import android.content.Context
import android.content.SharedPreferences
import com.aji.mazevelocity.model.UnlockableVehicle

/**
 * Utility object for managing player progress, unlocked vehicles, and high scores.
 */
object ProgressManager {
    private const val PREF_NAME = "mazevelocity_prefs"
    private const val KEY_UNLOCKED_VEHICLES = "unlocked_vehicles"
    private const val KEY_HIGH_SCORE = "high_score"

    fun getPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun getUnlockedVehicles(context: Context): Set<String> {
        return getPrefs(context).getStringSet(KEY_UNLOCKED_VEHICLES, setOf("Speedster")) ?: setOf("Speedster")
    }

    fun unlockVehicle(context: Context, vehicle: UnlockableVehicle) {
        val unlocked = getUnlockedVehicles(context).toMutableSet()
        unlocked.add(vehicle.name)
        getPrefs(context).edit().putStringSet(KEY_UNLOCKED_VEHICLES, unlocked).apply()
    }

    fun isVehicleUnlocked(context: Context, name: String): Boolean {
        return getUnlockedVehicles(context).contains(name)
    }

    fun getHighScore(context: Context): Int {
        return getPrefs(context).getInt(KEY_HIGH_SCORE, 0)
    }

    fun setHighScore(context: Context, score: Int) {
        getPrefs(context).edit().putInt(KEY_HIGH_SCORE, score).apply()
    }

    fun resetProgress(context: Context) {
        getPrefs(context).edit().clear().apply()
    }
}