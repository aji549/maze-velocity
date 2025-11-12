package com.aji.mazevelocity.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aji.mazevelocity.R
import com.aji.mazevelocity.model.UnlockableVehicle

/**
 * RecyclerView Adapter used for showing selectable vehicles.
 */
class VehicleAdapter(
    private val vehicles: List<UnlockableVehicle>,
    private val onVehicleSelected: ((UnlockableVehicle) -> Unit)? = null
) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {

    inner class VehicleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconView: ImageView = itemView.findViewById(R.id.vehicle_icon)
        val nameView: TextView = itemView.findViewById(R.id.vehicle_name)
        val unlockDescView: TextView = itemView.findViewById(R.id.vehicle_unlock_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val vehicle = vehicles[position]
        holder.iconView.setImageResource(vehicle.iconResId)
        holder.nameView.text = vehicle.name
        holder.unlockDescView.text = vehicle.unlockDesc
        holder.itemView.alpha = if (vehicle.unlocked) 1f else 0.5f
        holder.itemView.isEnabled = vehicle.unlocked
        holder.itemView.setOnClickListener {
            if (vehicle.unlocked) {
                onVehicleSelected?.invoke(vehicle)
            }
        }
    }

    override fun getItemCount(): Int = vehicles.size
}