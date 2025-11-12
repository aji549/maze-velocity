package com.aji.mazevelocity.util

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.media.MediaPlayer
import com.aji.mazevelocity.R

/**
 * Utility to manage music and sound effects playback.
 */
class SoundManager(context: Context) {
    private val soundPool: SoundPool
    private val soundEffects: MutableMap<String, Int> = mutableMapOf()
    private var mediaPlayer: MediaPlayer? = null

    init {
        val attrs = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(attrs)
            .build()

        // Example: Load sound effects (make sure files exist in res/raw)
        soundEffects["move"] = soundPool.load(context, R.raw.sfx_move, 1)
        soundEffects["goal"] = soundPool.load(context, R.raw.sfx_goal, 1)
        soundEffects["unlock"] = soundPool.load(context, R.raw.sfx_unlock, 1)
    }

    fun playSfx(effect: String) {
        val soundId = soundEffects[effect] ?: return
        soundPool.play(soundId, 1f, 1f, 1, 0, 1f)
    }

    fun playMusic(context: Context, resId: Int) {
        stopMusic()
        mediaPlayer = MediaPlayer.create(context, resId)?.apply {
            isLooping = true
            setVolume(0.7f, 0.7f)
            start()
        }
    }

    fun stopMusic() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    fun release() {
        soundPool.release()
        stopMusic()
    }
}