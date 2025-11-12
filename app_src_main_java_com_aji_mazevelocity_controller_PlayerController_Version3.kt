package com.aji.mazevelocity.controller

import com.aji.mazevelocity.model.MazeGrid
import com.aji.mazevelocity.model.MazeCell

/**
 * Controls player movement within the maze.
 */
class PlayerController(private val maze: MazeGrid) {
    var currentCell: MazeCell? = maze.getCell(0, 0)
        private set

    /**
     * Moves the player in the direction specified if possible.
     * @return true if move was successful, false if blocked
     */
    fun move(direction: Direction): Boolean {
        val (dr, dc) = when (direction) {
            Direction.UP -> Pair(-1, 0)
            Direction.DOWN -> Pair(1, 0)
            Direction.LEFT -> Pair(0, -1)
            Direction.RIGHT -> Pair(0, 1)
        }

        val nextCell = currentCell?.let {
            maze.getCell(it.row + dr, it.col + dc)
        } ?: return false

        // Can't move into walls
        return if (nextCell != null && !nextCell.isWall) {
            currentCell = nextCell
            true
        } else {
            false
        }
    }

    fun isAtGoal(): Boolean =
        currentCell?.isGoal == true

    enum class Direction {
        UP, DOWN, LEFT, RIGHT
    }
}