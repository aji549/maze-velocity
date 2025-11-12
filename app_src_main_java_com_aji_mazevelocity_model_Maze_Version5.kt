package com.aji.mazevelocity.model

/**
 * Represents a maze grid and logic for generation and access.
 */
class Maze(val rows: Int, val cols: Int) {

    val grid: Array<Array<MazeCell>> = Array(rows) { row ->
        Array(cols) { col -> MazeCell(row, col) }
    }

    /**
     * Generates the maze using recursive backtracking.
     */
    fun generateMaze(startRow: Int = 0, startCol: Int = 0) {
        fun backtrack(row: Int, col: Int) {
            grid[row][col].visited = true
            val directions = listOf(
                Pair(-1, 0), // Up
                Pair(1, 0),  // Down
                Pair(0, -1), // Left
                Pair(0, 1)   // Right
            ).shuffled()

            for ((dr, dc) in directions) {
                val newRow = row + dr
                val newCol = col + dc
                if (newRow in 0 until rows && newCol in 0 until cols && !grid[newRow][newCol].visited) {
                    // Remove the wall between current and next
                    if (dr == -1) { // Up
                        grid[row][col].topWall = false
                        grid[newRow][newCol].bottomWall = false
                    } else if (dr == 1) { // Down
                        grid[row][col].bottomWall = false
                        grid[newRow][newCol].topWall = false
                    } else if (dc == -1) { // Left
                        grid[row][col].leftWall = false
                        grid[newRow][newCol].rightWall = false
                    } else if (dc == 1) { // Right
                        grid[row][col].rightWall = false
                        grid[newRow][newCol].leftWall = false
                    }
                    backtrack(newRow, newCol)
                }
            }
        }

        backtrack(startRow, startCol)
    }

    /**
     * Returns the MazeCell at the given position.
     */
    fun getCell(row: Int, col: Int): MazeCell? {
        if (row in 0 until rows && col in 0 until cols) {
            return grid[row][col]
        }
        return null
    }
}