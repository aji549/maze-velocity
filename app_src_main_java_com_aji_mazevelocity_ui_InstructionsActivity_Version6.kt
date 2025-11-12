package com.aji.mazevelocity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R

/**
 * Activity for displaying game instructions to the player.
 */
class InstructionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instructions)
        // Just displays the instructions screen.
    }
}