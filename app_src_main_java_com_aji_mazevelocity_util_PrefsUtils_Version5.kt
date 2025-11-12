package com.aji.mazevelocity.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Helper utility for reading/writing general user preferences.
 */
object PrefsUtils {
    private const val PREFS_FILE = "mazevelocity_prefs"

    fun getPrefs(context: Context): SharedPreferences =
        context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)

    // Music enabled preference
    fun isMusicEnabled(context: Context): Boolean =
        getPrefs(context).getBoolean("music_enabled", true)

    fun setMusicEnabled(context: Context, enabled: Boolean) {
        getPrefs(context).edit().putBoolean("music_enabled", enabled).apply()
    }

    // SFX enabled preference
    fun isSfxEnabled(context: Context): Boolean =
        getPrefs(context).getBoolean("sfx_enabled", true)

    fun setSfxEnabled(context: Context, enabled: Boolean) {
        getPrefs(context).edit().putBoolean("sfx_enabled", enabled).apply()
    }
}