package com.ogrvassiem.partygames.ui.destination.startGame.presentation

import android.os.Parcelable
import com.ogrvassiem.partygames.aplication.readModels.TeamInfo
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ItemAttributesNavArgs(
    val attributes: @RawValue ArrayList<TeamInfo>,
    val categories: ArrayList<String>
) : Parcelable