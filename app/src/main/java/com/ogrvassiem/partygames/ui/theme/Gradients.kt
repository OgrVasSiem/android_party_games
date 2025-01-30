package com.ogrvassiem.partygames.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
class Gradients(
    bgButtonLinear: List<Pair<Float, Color>>,
    bgCardLinear: List<Pair<Float, Color>>,
    premiumBannerLinear: List<Pair<Float, Color>>,
    dark1: List<Pair<Float, Color>>,
    dark2: List<Pair<Float, Color>>,
) {
    var bgButtonLinear: List<Pair<Float, Color>> by mutableStateOf(bgButtonLinear)
        private set

    var bgCardLinear: List<Pair<Float, Color>> by mutableStateOf(bgCardLinear)
        private set

    var premiumBannerLinear: List<Pair<Float, Color>> by mutableStateOf(premiumBannerLinear)
        private set

    var dark1: List<Pair<Float, Color>> by mutableStateOf(dark1)
        private set

    var dark2: List<Pair<Float, Color>> by mutableStateOf(dark2)
        private set

    fun copy(): Gradients = Gradients(
        bgButtonLinear = bgButtonLinear,
        bgCardLinear = bgCardLinear,
        premiumBannerLinear = premiumBannerLinear,
        dark1 = dark1,
        dark2 = dark2,
    )

    fun updateGradientsFrom(other: Gradients) {
        bgButtonLinear = other.bgButtonLinear
        bgCardLinear = other.bgCardLinear
        premiumBannerLinear = other.premiumBannerLinear
        dark1 = other.dark1
        dark2 = other.dark2
    }

    override fun toString(): String {
        return """Gradients(
            bgButtonLinear=$bgButtonLinear, 
            bgCardLinear=$bgCardLinear, 
            premiumBannerLinear=$premiumBannerLinear, 
            dark1=$dark1, 
            dark2=$dark2, 
        )"""
    }
}

fun lightGradients() = Gradients(
    bgButtonLinear = listOf(
        0F to Color(0xFF00C4C7),
        1F to Color(0xFF00B356)
    ),
    bgCardLinear = listOf(
        0F to Color(0xFF4556FF),
        1F to Color(0xFFA513FF)
    ),
    premiumBannerLinear = listOf(
        0F to Color(0xFFA513FF),
        1F to Color(0xFFE33925)
    ),
    dark1 = listOf(
        0F to Color(0xFF0A0A0A).copy(1f),
        1F to Color(0xFF0A0A0A).copy(0f)
    ),
    dark2 = listOf(
        0F to Color(0xFF0A0A0A).copy(0f),
        1F to Color(0xFF0A0A0A).copy(1f)
    ),

)

val LocalGradients = staticCompositionLocalOf {
    lightGradients()
}