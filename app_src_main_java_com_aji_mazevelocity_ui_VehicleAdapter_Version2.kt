package com.aji.mazevelocity.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle

/**
 * Adapter to render grid items for vehicle selection.
 */
class VehicleAdapter(
    private val context: Context,
    private val vehicles: List<UnlockableVehicle>
) : BaseAdapter() {

    override fun getCount(): Int = vehicles.size

    override fun getItem(position: Int): Any = vehicles[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)
        val vehicle = vehicles[position]

        val iconView = view.findViewById<ImageView>(R.id.vehicle_icon)
        val nameView = view.findViewById<TextView>(R.id.vehicle_name)
        val unlockDescView = view.findViewById<TextView>(R.id.vehicle_unlock_desc)

        iconView.setImageResource(vehicle.iconResId)
        nameView.text = vehicle.name
        unlockDescView.text = vehicle.unlockDesc

        // Dim if locked
        view.alpha = if (vehicle.unlocked) 1.0f else 0.5f

        return view
    }
}