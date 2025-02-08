package com.ogrvassiem.partygames.aplication.readModels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TeamInfo(
    val iconRes: Int,
    val firstTitle: String,
    val secondTitle: String,
    val ending: String,
    val id: Int
) : Parcelable
