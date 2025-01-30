package com.ogrvassiem.partygames.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class TextStyles(
    val title: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val mainBoldTitle1: TextStyle,
    val mainBoldTitle2: TextStyle,
    val subtitle1: TextStyle,
    val subtitle2: TextStyle,
    val subtitle3: TextStyle,
    val button1: TextStyle,
    val bodyBold1: TextStyle,
    val body1: TextStyle,
    val bodySemyBold1: TextStyle,
    val bodyRegular1: TextStyle,
    val bodyRegular2: TextStyle,
    val name: TextStyle,
    val info: TextStyle,
) {
    constructor() : this(
        title = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight(500),
            letterSpacing = 0.03.sp
        ),
        title1 = TextStyle(
            fontSize = 22.sp,
            fontWeight = FontWeight(600),
            lineHeight = 27.sp
        ),
        title2 = TextStyle(
            fontSize = 17.sp,
            fontWeight = FontWeight(600),
            lineHeight = 22.sp
        ),
        title3 = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight(600),
            lineHeight = 21.sp
        ),
        mainBoldTitle1 = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight(600),
            lineHeight = 36.sp
        ),
        mainBoldTitle2 = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight(600),
            lineHeight = 27.sp
        ),
        subtitle1 = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            lineHeight = 24.sp
        ),
        subtitle2 = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight(400),
            lineHeight = 20.sp
        ),
        subtitle3 = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight(400),
            lineHeight = 19.sp,
            letterSpacing = (-0.24).sp
        ),
        button1 = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(600),
            lineHeight = 24.sp
        ),
        bodyBold1 = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            lineHeight = 24.sp
        ),
        body1 = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight(400),
            lineHeight = 24.sp
        ),
        bodySemyBold1 = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight(500),
            lineHeight = 24.sp
        ),
        bodyRegular1 = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            lineHeight = 24.sp
        ),
        bodyRegular2 = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight(400),
            lineHeight = 15.sp
        ),
        name = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight(800),
            lineHeight = 22.sp
        ),
        info = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            lineHeight = 15.sp
        ),
    )
}

val LocalTextStyles = staticCompositionLocalOf { TextStyles() }
