package com.aji.mazevelocity.model

/**
 * Represents the player in the maze.
 */
data class Player(
    var row: Int,
    var col: Int,
    var score: Int = 0
)