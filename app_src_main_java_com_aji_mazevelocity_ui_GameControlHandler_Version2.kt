package com.aji.mazevelocity.ui

import android.widget.ImageButton
import com.aji.mazevelocity.controller.PlayerController

/**
 * Handles control button interactions for maze movement.
 */
class GameControlHandler(
    private val playerController: PlayerController,
    private val mazeView: MazeView,
    btnUp: ImageButton,
    btnDown: ImageButton,
    btnLeft: ImageButton,
    btnRight: ImageButton,
    onMove: (() -> Unit)? = null
) {
    init {
        btnUp.setOnClickListener {
            if (playerController.move(PlayerController.Direction.UP)) {
                mazeView.refresh()
                onMove?.invoke()
            }
        }
        btnDown.setOnClickListener {
            if (playerController.move(PlayerController.Direction.DOWN)) {
                mazeView.refresh()
                onMove?.invoke()
            }
        }
        btnLeft.setOnClickListener {
            if (playerController.move(PlayerController.Direction.LEFT)) {
                mazeView.refresh()
                onMove?.invoke()
            }
        }
        btnRight.setOnClickListener {
            if (playerController.move(PlayerController.Direction.RIGHT)) {
                mazeView.refresh()
                onMove?.invoke()
            }
        }
    }
}