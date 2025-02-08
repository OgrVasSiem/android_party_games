package com.ogrvassiem.partygames.ui.components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ogrvassiem.partygames.ui.theme.Theme

@Composable
fun DefaultTextButton(
    modifier: Modifier = Modifier,
    minHeight: Dp = 56.dp,
    bgColor: Color = Theme.colors.accent,
    shape: RoundedCornerShape = RoundedCornerShape(16.dp),
    contentAlignment: Alignment = Alignment.Center,
    enabled: Boolean = true,
    text: String,
    textColor: Color = Theme.colors.white,
    textStyle: TextStyle = Theme.textStyles.button1,
    textModifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    DefaultButton(
        modifier = modifier,
        minHeight = minHeight,
        bgColor = bgColor,
        shape = shape,
        contentAlignment = contentAlignment,
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            text = text,
            color = textColor,
            style = textStyle,
            modifier = textModifier
        )
    }
}

@Composable
fun DefaultGradientTextButton(
    modifier: Modifier = Modifier,
    minHeight: Dp = 56.dp,
    bgColor: List<Pair<Float, Color>> = Theme.gradients.bgButtonLinear,
    shape: RoundedCornerShape = RoundedCornerShape(16.dp),
    contentAlignment: Alignment = Alignment.Center,
    enabled: Boolean = true,
    text: String,
    textColor: Color = Theme.colors.white,
    textStyle: TextStyle = Theme.textStyles.button1,
    textModifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    DefaultGradientButton(
        modifier = modifier,
        minHeight = minHeight,
        bgColor = bgColor,
        shape = shape,
        contentAlignment = contentAlignment,
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            text = text,
            color = textColor,
            style = textStyle,
            modifier = textModifier
        )
    }
}