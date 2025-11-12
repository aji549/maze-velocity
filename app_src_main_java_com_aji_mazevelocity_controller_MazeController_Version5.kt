package com.aji.mazevelocity.controller

/**
 * Responsible for controlling Maze game state and handling player movement.
 */
class MazeController(private val gameState: MazeGameState) {

    /**
     * Moves the player in the given direction if possible.
     * @param direction One of "up", "down", "left", "right".
     * @return true if the move was successful.
     */
    fun movePlayer(direction: String): Boolean {
        val player = gameState.player
        val currentCell = gameState.maze.getCell(player.row, player.col) ?: return false

        val (newRow, newCol) = if (direction == "up") {
            if (!currentCell.topWall) player.row - 1 to player.col else player.row to player.col
        } else if (direction == "down") {
            if (!currentCell.bottomWall) player.row + 1 to player.col else player.row to player.col
        } else if (direction == "left") {
            if (!currentCell.leftWall) player.row to player.col - 1 else player.row to player.col
        } else if (direction == "right") {
            if (!currentCell.rightWall) player.row to player.col + 1 else player.row to player.col
        } else player.row to player.col

        if (newRow != player.row || newCol != player.col) {
            player.row = newRow
            player.col = newCol
            gameState.score++
            return true
        }

        return false
    }

    /**
     * Resets the game.
     */
    fun resetGame() {
        gameState.score = 0
        gameState.timeElapsed = 0L
        gameState.isGameOver = false
        gameState.player.row = 0
        gameState.player.col = 0
        gameState.maze.generateMaze()
    }

    /**
     * Checks if the player has reached the goal cell (bottom-right by default).
     */
    fun isGoalReached(): Boolean {
        val player = gameState.player
        return player.row == gameState.maze.rows - 1 && player.col == gameState.maze.cols - 1
    }
}

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