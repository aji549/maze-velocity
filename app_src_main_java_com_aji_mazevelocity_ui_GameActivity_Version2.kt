package com.aji.mazevelocity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.Maze

/**
 * Activity for running the main maze game.
 */
class GameActivity : AppCompatActivity() {
    lateinit var maze: Maze

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // Example maze size, can be made configurable
        maze = Maze(rows = 10, cols = 10)
        // TODO: setup MazeView to actually draw the maze
        // TODO: setup game overlays (score, timer), controls, etc.
    }
}