package com.ogrvassiem.partygames.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
class Colors(
    white: Color,
    black: Color,
) {
    var white: Color by mutableStateOf(white)
        private set

    var black: Color by mutableStateOf(black)
        private set

    fun copy(): Colors {
        return Colors(
            white = white,
            black = black,
        )
    }

    override fun toString(): String {
        return """Colors(
            white=$white,
            black=$black,
        )"""
    }
}

fun lightColors(): Colors = Colors(
    white = Color(0xffffffff),
    black = Color(0xff000000),
)

val LocalColors = staticCompositionLocalOf { lightColors() }