package com.ogrvassiem.partygames.aplication.readModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamScore(
    val firstTitle: String?,
    val secondTitle: String?,
    val id: Int,
    val score: Int?,
    val gameCount: Int?
) : Parcelable

@Parcelize
data class GameAtributesNavArgs(
    val currentCommand: ArrayList<TeamScore>,
    val categories: ArrayList<String>
) : Parcelable
