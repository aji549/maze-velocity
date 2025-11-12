package com.aji.mazevelocity.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.aji.mazevelocity.model.Maze
import com.aji.mazevelocity.model.Cell
import com.aji.mazevelocity.R

/**
 * Custom View for rendering the maze on screen.
 */
class MazeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {

    var maze: Maze? = null
    var cellSize: Float = 0f
    private val wallPaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = resources.getDimension(R.dimen.maze_wall_thickness)
    }

    fun setMaze(maze: Maze) {
        this.maze = maze
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        maze?.let { maze ->
            val rows = maze.rows
            val cols = maze.cols
            cellSize = (width.coerceAtMost(height) / rows.toFloat())
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    val cell = maze.getCell(row, col) ?: continue
                    val x = col * cellSize
                    val y = row * cellSize

                    // Draw walls if present
                    if (cell.topWall)    canvas.drawLine(x, y, x + cellSize, y, wallPaint)
                    if (cell.leftWall)   canvas.drawLine(x, y, x, y + cellSize, wallPaint)
                    if (cell.rightWall)  canvas.drawLine(x + cellSize, y, x + cellSize, y + cellSize, wallPaint)
                    if (cell.bottomWall) canvas.drawLine(x, y + cellSize, x + cellSize, y + cellSize, wallPaint)
                }
            }
        }
        // Optionally draw player/goal overlays here
    }
}