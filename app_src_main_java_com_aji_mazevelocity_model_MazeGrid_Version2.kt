package com.aji.mazevelocity.model

/**
 * Represents the grid structure of the maze, including cells and basic operations.
 */
class MazeGrid(val rows: Int, val cols: Int) {

    val cells: Array<Array<MazeCell>> = Array(rows) { row ->
        Array(cols) { col ->
            MazeCell(row, col)
        }
    }

    fun getCell(row: Int, col: Int): MazeCell? {
        return if (row in 0 until rows && col in 0 until cols) cells[row][col] else null
    }

    fun forEachCell(action: (MazeCell) -> Unit) {
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                action(cells[row][col])
            }
        }
    }
}