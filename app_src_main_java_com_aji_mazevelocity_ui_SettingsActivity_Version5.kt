package com.aji.mazevelocity.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R
import com.aji.mazevelocity.util.ProgressManager

class SettingsActivity : AppCompatActivity() {
    private lateinit var musicSwitch: Switch
    private lateinit var sfxSwitch: Switch
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        musicSwitch = findViewById(R.id.music_switch)
        sfxSwitch = findViewById(R.id.sfx_switch)
        resetButton = findViewById(R.id.reset_progress_button)

        // TODO: Load and save user preferences for music/sfx

        resetButton.setOnClickListener {
            ProgressManager(this).resetProgress()
            // Optionally show a toast/confirmation
        }
    }
}