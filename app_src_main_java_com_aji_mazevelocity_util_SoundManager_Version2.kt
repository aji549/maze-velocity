package com.aji.mazevelocity.util

import android.content.Context
import android.media.MediaPlayer
import com.aji.mazevelocity.R

/**
 * Handles sound effects and music for Maze Velocity.
 */
object SoundManager {
    private var mediaPlayer: MediaPlayer? = null

    fun playWinSound(context: Context) {
        play(context, R.raw.win_sound)
    }

    fun playLoseSound(context: Context) {
        play(context, R.raw.lose_sound)
    }

    fun playMoveSound(context: Context) {
        play(context, R.raw.move_sound)
    }

    private fun play(context: Context, soundResId: Int) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(context, soundResId)
        mediaPlayer?.setOnCompletionListener { it.release() }
        mediaPlayer?.start()
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}