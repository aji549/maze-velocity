package com.aji.mazevelocity.util

import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle

/**
 * Utility functions for vehicle/character icons.
 */
object VehicleIconUtils {

    /**
     * Provides a list of all possible vehicles (with their drawable resource IDs).
     */
    fun getAllVehicles(): List<UnlockableVehicle> {
        return listOf(
            UnlockableVehicle(R.drawable.car1, "Speedster", "Unlock at level 10", false),
            UnlockableVehicle(R.drawable.car2, "Chase Master", "Unlock by winning a chase", false),
            UnlockableVehicle(R.drawable.car3, "Maze Runner", "Unlocked by default", true)
        )
    }

    /**
     * Gets a vehicle by name.
     */
    fun getVehicleByName(name: String): UnlockableVehicle? {
        return getAllVehicles().find { it.name == name }
    }
}