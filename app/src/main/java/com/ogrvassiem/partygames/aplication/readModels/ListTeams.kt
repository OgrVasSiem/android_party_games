package com.ogrvassiem.partygames.aplication.readModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ListTeams(
    val id: Int,
    val firstTitle: String,
    val secondTitle: String,
    val ending: String,
    val iconRes: Int,
    val gameCount: Int? = null,
    val score: Int? = null,
) : Parcelable