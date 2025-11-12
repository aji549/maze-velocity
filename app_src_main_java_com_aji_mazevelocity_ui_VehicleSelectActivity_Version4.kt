package com.aji.mazevelocity.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.model.UnlockableVehicle
import com.aji.mazevelocity.util.ProgressManager
import com.aji.mazevelocity.R

class VehicleSelectActivity : AppCompatActivity() {

    private lateinit var progressManager: ProgressManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_select)
        progressManager = ProgressManager(this)

        val unlockables = listOf(
            UnlockableVehicle("vehicle_default", R.drawable.car1, "Standard Car", "Unlocked by default.", true, UnlockRequirement.ByDefault),
            UnlockableVehicle("vehicle_sport", R.drawable.car2, "Speedster", "Unlock at level 10.", false, UnlockRequirement.ByLevel(10)),
            UnlockableVehicle("vehicle_chase", R.drawable.car3, "Interceptor", "Unlock by winning a chase.", false, UnlockRequirement.ByAchievement("CHASE_WIN")),
            UnlockableVehicle("vehicle_pursuit", R.drawable.car4, "Pursuit Pro", "Unlock by winning a pursuit.", false, UnlockRequirement.ByAchievement("PURSUIT_WIN"))
        )

        unlockables.forEach { unlockable ->
            val view = findViewById<ImageView>(resources.getIdentifier(unlockable.id, "id", packageName))
            if (progressManager.isUnlocked(unlockable.id) || unlockable.unlocked) {
                view.isEnabled = true
                view.alpha = 1f
                view.setOnClickListener {
                    saveVehicleSelection(unlockable.id)
                    showModeSelection()
                }
            } else {
                view.isEnabled = false
                view.alpha = 0.4f
                view.setOnClickListener {
                    Toast.makeText(this, unlockable.description, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val toggleMode = findViewById<ToggleButton>(R.id.toggleMode)
        toggleMode.setOnCheckedChangeListener { _, isChecked ->
            // Handle avatar/vehicle toggle
        }
    }

    private fun saveVehicleSelection(id: String) {
        getSharedPreferences("maze_prefs", MODE_PRIVATE).edit()
            .putString("selected_vehicle", id)
            .apply()
    }

    private fun showModeSelection() {
        // Show game mode selection dialog ("Maze", "Chase", "Pursuit")
        // Save chosen mode in prefs, start MazeActivity
    }
}