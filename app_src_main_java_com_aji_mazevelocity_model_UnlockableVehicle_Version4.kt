package com.aji.mazevelocity.model

import androidx.annotation.DrawableRes

data class UnlockableVehicle(
    @DrawableRes val iconResId: Int,
    val name: String,
    val unlockDescription: String,
    val unlocked: Boolean
)