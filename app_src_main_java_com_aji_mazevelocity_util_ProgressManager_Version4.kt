package com.aji.mazevelocity.util

import android.content.Context

class ProgressManager(private val context: Context) {
    private val prefs = context.getSharedPreferences("vehicle_unlocks", Context.MODE_PRIVATE)
    fun unlock(id: String) { prefs.edit().putBoolean(id, true).apply() }
    fun isUnlocked(id: String): Boolean = prefs.getBoolean(id, false)
}