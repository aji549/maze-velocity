package com.aji.mazevelocity.util

import com.aji.mazevelocity.model.MazeGrid
import com.aji.mazevelocity.model.MazeCell
import kotlin.random.Random

/**
 * Utility for generating random mazes using recursive backtracking.
 */
object MazeGenerator {

    fun generateMaze(rows: Int, cols: Int): MazeGrid {
        val maze = MazeGrid(rows, cols)
        val stack = mutableListOf<MazeCell>()
        val startCell = maze.getCell(0, 0) ?: return maze
        startCell.visited = true
        startCell.isStart = true
        stack.add(startCell)

        while (stack.isNotEmpty()) {
            val current = stack.last()
            val neighbors = getUnvisitedNeighbors(current, maze)

            if (neighbors.isNotEmpty()) {
                val next = neighbors.random()
                removeWallBetween(current, next)
                next.visited = true
                stack.add(next)
            } else {
                stack.removeAt(stack.size - 1)
            }
        }

        // Choose last cell as goal
        val goalCell = maze.getCell(rows - 1, cols - 1)
        goalCell?.isGoal = true

        // Set all walls to false for visited cells (optional reset)
        maze.forEachCell {
            if (it.visited) it.isWall = false else it.isWall = true
            it.visited = false
        }

        return maze
    }

    private fun getUnvisitedNeighbors(cell: MazeCell, maze: MazeGrid): List<MazeCell> {
        val deltas = listOf(
            Pair(-1, 0),
            Pair(1, 0),
            Pair(0, -1),
            Pair(0, 1)
        )
        val neighbors = mutableListOf<MazeCell>()
        for ((dr, dc) in deltas) {
            val neighbor = maze.getCell(cell.row + dr, cell.col + dc)
            if (neighbor != null && !neighbor.visited) {
                neighbors.add(neighbor)
            }
        }
        return neighbors
    }

    private fun removeWallBetween(current: MazeCell, next: MazeCell) {
        // This method would update the model/grid so that movement is allowed between the two cells.
        // Actual wall fields or structure depend on how rendering and collision is managed.
        // For basic logic, simply marking both cells as visited/non-wall suffices here.
        current.isWall = false
        next.isWall = false
    }
}