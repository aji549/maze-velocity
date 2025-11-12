package com.aji.mazevelocity.util

import android.content.Context

/**
 * Utility for generic SharedPreferences interaction.
 */
object PrefsUtils {
    fun getString(context: Context, key: String, default: String = ""): String =
        context.getSharedPreferences("mazevelocity_prefs", Context.MODE_PRIVATE)
            .getString(key, default) ?: default

    fun putString(context: Context, key: String, value: String) {
        context.getSharedPreferences("mazevelocity_prefs", Context.MODE_PRIVATE)
            .edit().putString(key, value).apply()
    }

    fun getInt(context: Context, key: String, default: Int = 0): Int =
        context.getSharedPreferences("mazevelocity_prefs", Context.MODE_PRIVATE)
            .getInt(key, default)

    fun putInt(context: Context, key: String, value: Int) {
        context.getSharedPreferences("mazevelocity_prefs", Context.MODE_PRIVATE)
            .edit().putInt(key, value).apply()
    }
}