package com.aji.mazevelocity.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle

class VehicleSelectActivity : AppCompatActivity() {
    // Sample vehicle data
    private val vehicles = listOf(
        UnlockableVehicle(R.drawable.car1, "Speedster", "Unlock at level 10", false),
        UnlockableVehicle(R.drawable.car2, "Chase Master", "Unlock by winning a chase", false),
        UnlockableVehicle(R.drawable.car3, "Maze Runner", "Unlocked by default", true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_select)

        // Example: Set up the first vehicle in the UI
        val vehicleIcon = findViewById<ImageView>(R.id.vehicle_icon)
        val vehicleName = findViewById<TextView>(R.id.vehicle_name)
        val unlockDesc = findViewById<TextView>(R.id.unlock_desc)

        val selectedVehicle = vehicles[0]
        vehicleIcon.setImageResource(selectedVehicle.iconResId)
        vehicleName.text = selectedVehicle.name
        unlockDesc.text = selectedVehicle.unlockDescription

        // TODO: Add selection logic, horizontal scrolling, and unlock state handling
    }
}