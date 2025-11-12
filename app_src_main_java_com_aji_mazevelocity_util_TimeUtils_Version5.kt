package com.aji.mazevelocity.util

/**
 * Utility object for formatting time values for display.
 */
object TimeUtils {

    /**
     * Converts elapsed milliseconds to a formatted string mm:ss.
     */
    fun formatTime(millis: Long): String {
        val seconds = millis / 1000
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }
}