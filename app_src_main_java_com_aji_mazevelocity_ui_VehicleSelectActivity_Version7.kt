package com.aji.mazevelocity.ui

import android.os.Bundle
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle
import com.aji.mazevelocity.util.VehicleIconUtils

/**
 * Activity for selecting the player’s vehicle before starting a game.
 */
class VehicleSelectActivity : AppCompatActivity() {

    private lateinit var vehicleGrid: GridView
    private lateinit var vehicleAdapter: VehicleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_select)

        vehicleGrid = findViewById(R.id.vehicle_grid)
        val vehicles: List<UnlockableVehicle> = VehicleIconUtils.getAllVehicles()
        vehicleAdapter = VehicleAdapter(this, vehicles)
        vehicleGrid.adapter = vehicleAdapter

        // Optional: set click listener for selection, updating preferences, etc.
    }
}