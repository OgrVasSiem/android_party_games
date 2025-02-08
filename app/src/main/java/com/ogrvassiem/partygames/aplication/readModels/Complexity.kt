package com.ogrvassiem.partygames.aplication.readModels

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.ogrvassiem.partygames.R

enum class Complexity(@StringRes val resourceId: Int) {
    EASY(R.string.easy),
    MEDIUM(R.string.medium),
    HIGH(R.string.high)
}
