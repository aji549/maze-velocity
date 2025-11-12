package com.aji.mazevelocity.model

/**
 * Represents a single cell in the maze.
 */
data class Cell(
    val row: Int,
    val col: Int,
    var topWall: Boolean = true,
    var bottomWall: Boolean = true,
    var leftWall: Boolean = true,
    var rightWall: Boolean = true
)