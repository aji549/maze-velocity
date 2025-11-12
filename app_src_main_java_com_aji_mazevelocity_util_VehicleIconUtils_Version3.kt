package com.aji.mazevelocity.util

import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle

/**
 * Utility for providing all available vehicles and their icons/unlock descriptions.
 */
object VehicleIconUtils {
    fun getAllVehicles(): List<UnlockableVehicle> {
        return listOf(
            UnlockableVehicle(
                iconResId = R.drawable.ic_speedster,
                name = "Speedster",
                unlockDesc = "Default vehicle. Available from the start.",
                unlocked = true
            ),
            UnlockableVehicle(
                iconResId = R.drawable.ic_commando,
                name = "Commando",
                unlockDesc = "Unlock by reaching a score of 500.",
                unlocked = false
            ),
            UnlockableVehicle(
                iconResId = R.drawable.ic_blaze,
                name = "Blaze",
                unlockDesc = "Unlock by completing all levels in Classic mode.",
                unlocked = false
            ),
            UnlockableVehicle(
                iconResId = R.drawable.ic_stealth,
                name = "Stealth",
                unlockDesc = "Unlock by finishing a maze in under 30 seconds.",
                unlocked = false
            )
            // Add more vehicles as needed
        )
    }
}