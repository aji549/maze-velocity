package com.aji.mazevelocity.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        // Find the close button and set its click listener to finish the activity
        findViewById<Button>(R.id.button_close)?.setOnClickListener {
            finish()
        }
    }
}