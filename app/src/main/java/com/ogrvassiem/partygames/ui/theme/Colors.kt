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
    textOnboarding: Color,
    accent: Color,
    redAccent: Color,
    bg: Color,
    card: Color,
    textGray: Color,
) {
    var white: Color by mutableStateOf(white)
        private set

    var black: Color by mutableStateOf(black)
        private set

    var textOnboarding: Color by mutableStateOf(textOnboarding)
        private set

    var accent: Color by mutableStateOf(accent)
        private set

    var redAccent: Color by mutableStateOf(redAccent)
        private set

    var bg: Color by mutableStateOf(bg)
        private set

    var card: Color by mutableStateOf(card)
        private set

    var textGray: Color by mutableStateOf(textGray)
        private set



    fun copy(): Colors {
        return Colors(
            white = white,
            black = black,
            textOnboarding = textOnboarding,
            accent = accent,
            redAccent = redAccent,
            bg = bg,
            card = card,
            textGray = textGray,
        )
    }

    override fun toString(): String {
        return """Colors(
            white=$white,
            black=$black,
            textOnboarding=$textOnboarding,
            accent=$accent,
            redAccent=$redAccent,
            bg=$bg,
            card=$card,
            textGray=$textGray,
        )"""
    }
}

fun lightColors(): Colors = Colors(
    white = Color(0xffffffff),
    black = Color(0xff000000),
    accent = Color(0xff3465df),
    redAccent = Color(0xffFF2A2D),
    bg = Color(0xffabc1f7),
    card = Color(0xffd3ddfb),
    textOnboarding = Color(0xffe2e4f8).copy(alpha = 0.88f),
    textGray = Color(0xa3454a85),

    )

val LocalColors = staticCompositionLocalOf { lightColors() }