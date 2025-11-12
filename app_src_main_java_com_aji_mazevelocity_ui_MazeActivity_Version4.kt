package com.aji.mazevelocity.ui

import android.content.Context
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.os.Handler
import android.view.View
import com.aji.mazevelocity.util.AchievementsManager
import com.aji.mazevelocity.util.ProgressManager
import com.aji.mazevelocity.R

class MazeActivity(context: Context) : View(context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("maze_prefs", Context.MODE_PRIVATE)
    private val vehicleId = prefs.getString("selected_vehicle", "vehicle_default")
    private val vehicleDrawable = getVehicleDrawableById(vehicleId)
    private val gameMode = prefs.getString("game_mode", "maze")
    private var px = 0f
    private var py = 0f
    private val handler = Handler()

    override fun onDraw(canvas: Canvas) {
        val bitmap = BitmapFactory.decodeResource(resources, vehicleDrawable)
        canvas.drawBitmap(bitmap, px, py, null)
        // Draw AI vehicle(s) for chase/pursuit if needed
        // Draw maze, collectibles...
    }

    private fun getVehicleDrawableById(id: String?): Int {
        return when (id) {
            "vehicle_default" -> R.drawable.car1
            "vehicle_sport" -> R.drawable.car2
            "vehicle_chase" -> R.drawable.car3
            "vehicle_pursuit" -> R.drawable.car4
            else -> R.drawable.car1
        }
    }

    fun onGameEndChaseWin() {
        AchievementsManager(context, ProgressManager(context)).onChaseWin()
        // Show unlock dialog, update UI...
    }

    fun onGameEndPursuitWin() {
        AchievementsManager(context, ProgressManager(context)).onPursuitWin()
        // Show unlock dialog, update UI...
    }
}