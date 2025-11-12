package com.aji.mazevelocity.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.GameMode
import com.aji.mazevelocity.model.MazeGrid
import com.aji.mazevelocity.controller.PlayerController
import com.aji.mazevelocity.util.MazeGenerator

/**
 * Main activity for playing Maze Velocity.
 */
class GameActivity : AppCompatActivity() {

    private lateinit var mazeGrid: MazeGrid
    private lateinit var playerController: PlayerController
    private lateinit var scoreView: TextView
    private lateinit var timeView: TextView
    private var gameMode: GameMode = GameMode.CLASSIC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        scoreView = findViewById(R.id.score_overlay)
        timeView = findViewById(R.id.time_overlay)

        gameMode = intent.getSerializableExtra("game_mode") as? GameMode ?: GameMode.CLASSIC

        mazeGrid = MazeGenerator.generateMaze(10, 10) // default size or load from config
        playerController = PlayerController(mazeGrid)

        // TODO: Add rendering logic for maze and player, setup controls (swipe/arrow), timer, scoring, win/lose overlays, etc.
    }
}