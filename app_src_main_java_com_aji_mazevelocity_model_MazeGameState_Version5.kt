package com.aji.mazevelocity.model

/**
 * Holds the full state of the maze game for saving/loading and logic.
 */
data class MazeGameState(
    val maze: Maze,
    val player: Player,
    var score: Int = 0,
    var timeElapsed: Long = 0L,
    var isGameOver: Boolean = false
)