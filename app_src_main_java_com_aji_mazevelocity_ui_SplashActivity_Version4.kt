package com.aji.mazevelocity.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Optional: setContentView(R.layout.activity_splash) if you have a layout

        // Show splash for 1.5 seconds, then launch the VehicleSelectActivity
        window.decorView.postDelayed({
            startActivity(Intent(this, VehicleSelectActivity::class.java))
            finish()
        }, 1500)
    }
}