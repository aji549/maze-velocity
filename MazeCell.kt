package com.aji.mazevelocity.model

/**
 * Represents a single cell in the maze.
 */
data class MazeCell(
    val row: Int,
    val col: Int,
    var isWall: Boolean = false,
    var isStart: Boolean = false,
    var isGoal: Boolean = false,
    var visited: Boolean = false
)