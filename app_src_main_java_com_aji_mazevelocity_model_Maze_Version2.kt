package com.aji.mazevelocity.model

/**
 * Represents the maze grid and logic for generating and accessing cells.
 */
class Maze(val rows: Int, val cols: Int) {
    private val grid: Array<Array<Cell>> = Array(rows) { row ->
        Array(cols) { col -> Cell(row, col) }
    }

    init {
        generateMaze()
    }

    /**
     * Generates the maze using simple randomized DFS algorithm.
     */
    fun generateMaze() {
        // Simple recursive backtracking for maze generation
        fun dfs(row: Int, col: Int, visited: Array<Array<Boolean>>) {
            visited[row][col] = true
            val directions = listOf(
                Pair(-1, 0), // up
                Pair(1, 0),  // down
                Pair(0, -1), // left
                Pair(0, 1)   // right
            ).shuffled()
            for ((dr, dc) in directions) {
                val nr = row + dr
                val nc = col + dc
                if (nr in 0 until rows && nc in 0 until cols && !visited[nr][nc]) {
                    // Knock down wall between adjacent cells
                    if (dr == -1) { grid[row][col].topWall = false; grid[nr][nc].bottomWall = false }
                    if (dr == 1)  { grid[row][col].bottomWall = false; grid[nr][nc].topWall = false }
                    if (dc == -1) { grid[row][col].leftWall = false; grid[nr][nc].rightWall = false }
                    if (dc == 1)  { grid[row][col].rightWall = false; grid[nr][nc].leftWall = false }
                    dfs(nr, nc, visited)
                }
            }
        }
        // Reset all walls before generation
        for (row in grid) {
            for (cell in row) {
                cell.topWall = true
                cell.bottomWall = true
                cell.leftWall = true
                cell.rightWall = true
            }
        }
        val visited = Array(rows) { Array(cols) { false } }
        dfs(0, 0, visited)
    }

    /**
     * Returns the cell at the given row and col, or null if out of bounds.
     */
    fun getCell(row: Int, col: Int): Cell? {
        return if (row in 0 until rows && col in 0 until cols) grid[row][col] else null
    }
}