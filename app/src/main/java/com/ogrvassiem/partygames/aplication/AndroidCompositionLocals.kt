package com.ogrvassiem.partygames.aplication

import android.app.Activity
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.staticCompositionLocalOf

val LocalActivity = staticCompositionLocalOf<Activity> {
    noLocalProvidedFor("LocalActivity")
}

private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}

val LocalModalBottomSheetState = staticCompositionLocalOf<ModalBottomSheetState> { error("") }