package com.aji.mazevelocity.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.aji.mazevelocity.model.MazeGrid
import com.aji.mazevelocity.controller.PlayerController

/**
 * Custom View for rendering the maze and player position.
 */
class MazeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    var mazeGrid: MazeGrid? = null
    var playerController: PlayerController? = null

    private val wallPaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }
    private val pathPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }
    private val startPaint = Paint().apply {
        color = Color.parseColor("#3F51B5")
        style = Paint.Style.FILL
    }
    private val goalPaint = Paint().apply {
        color = Color.parseColor("#4CAF50")
        style = Paint.Style.FILL
    }
    private val playerPaint = Paint().apply {
        color = Color.parseColor("#FFC107")
        style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val maze = mazeGrid ?: return
        val cellWidth = width / maze.cols.toFloat()
        val cellHeight = height / maze.rows.toFloat()
        for (row in 0 until maze.rows) {
            for (col in 0 until maze.cols) {
                val cell = maze.getCell(row, col) ?: continue
                val left = col * cellWidth
                val top = row * cellHeight
                val right = left + cellWidth
                val bottom = top + cellHeight
                when {
                    cell.isWall -> canvas.drawRect(left, top, right, bottom, wallPaint)
                    cell.isGoal -> canvas.drawRect(left, top, right, bottom, goalPaint)
                    cell.isStart -> canvas.drawRect(left, top, right, bottom, startPaint)
                    else -> canvas.drawRect(left, top, right, bottom, pathPaint)
                }
            }
        }
        // Draw player
        playerController?.currentCell?.let { cell ->
            val cx = (cell.col + 0.5f) * cellWidth
            val cy = (cell.row + 0.5f) * cellHeight
            val radius = 0.35f * minOf(cellWidth, cellHeight)
            canvas.drawCircle(cx, cy, radius, playerPaint)
        }
    }

    /**
     * Call this after movement or maze updates
     */
    fun refresh() {
        invalidate()
    }
}