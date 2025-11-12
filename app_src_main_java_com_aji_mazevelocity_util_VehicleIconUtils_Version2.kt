package com.aji.mazevelocity.util

import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle

/**
 * Provides a list of all available vehicles for selection.
 */
object VehicleIconUtils {
    fun getAllVehicles(): List<UnlockableVehicle> {
        return listOf(
            UnlockableVehicle(
                iconResId = R.drawable.ic_vehicle_speedster,
                name = "Speedster",
                unlockDesc = "Unlocked by default",
                unlocked = true
            ),
            UnlockableVehicle(
                iconResId = R.drawable.ic_vehicle_chase_master,
                name = "Chase Master",
                unlockDesc = "Unlock by completing Level 3",
                unlocked = false
            ),
            UnlockableVehicle(
                iconResId = R.drawable.ic_vehicle_maze_runner,
                name = "Maze Runner",
                unlockDesc = "Unlock by collecting 500 points",
                unlocked = false
            )
            // Add other vehicles as needed
        )
    }
}