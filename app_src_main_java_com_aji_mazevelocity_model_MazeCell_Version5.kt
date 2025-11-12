package com.aji.mazevelocity.model

/**
 * Data class representing a cell in the maze.
 * Each cell can have walls on four sides and may be marked as visited for maze generation.
 */
data class MazeCell(
    val row: Int,
    val col: Int,
    var visited: Boolean = false,
    var topWall: Boolean = true,
    var bottomWall: Boolean = true,
    var leftWall: Boolean = true,
    var rightWall: Boolean = true
)