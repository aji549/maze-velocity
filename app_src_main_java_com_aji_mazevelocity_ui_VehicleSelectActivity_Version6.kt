package com.aji.mazevelocity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aji.mazevelocity.R
import com.aji.mazevelocity.util.VehicleIconUtils

/**
 * Activity for displaying and selecting unlockable vehicles.
 */
class VehicleSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_select)

        val vehicleRecycler = findViewById<RecyclerView>(R.id.vehicle_recycler)
        vehicleRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val vehicles = VehicleIconUtils.getAllVehicles()
        // You'll need to implement VehicleAdapter for this to work
        vehicleRecycler.adapter = VehicleAdapter(vehicles)
    }
}