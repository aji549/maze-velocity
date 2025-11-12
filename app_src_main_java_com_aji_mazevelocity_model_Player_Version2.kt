package com.aji.mazevelocity.model

/**
 * Data class representing a player in the maze.
 */
data class Player(
    var row: Int,
    var col: Int,
    var score: Int = 0,
    var vehicle: UnlockableVehicle? = null
)