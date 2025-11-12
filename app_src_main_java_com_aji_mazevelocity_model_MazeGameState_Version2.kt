package com.aji.mazevelocity.model

/**
 * Holds the current game state for a maze session.
 */
data class MazeGameState(
    var maze: Maze,
    var player: Player,
    var goalCell: Cell,
    var score: Int = 0,
    var timeElapsed: Long = 0L,
    var isGameOver: Boolean = false
)