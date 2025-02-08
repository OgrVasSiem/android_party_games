package com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CategoriesNavArgs(
    val categories: ArrayList<String>
) : Parcelable
