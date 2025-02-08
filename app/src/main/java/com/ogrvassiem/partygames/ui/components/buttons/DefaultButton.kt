package com.ogrvassiem.partygames.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ogrvassiem.partygames.ui.utils.linearGradient
import com.ogrvassiem.partygames.ui.theme.Theme

@Composable
fun DefaultButton(
    modifier: Modifier = Modifier,
    minHeight: Dp = 60.dp,
    bgColor: Color = Theme.colors.accent,
    shape: RoundedCornerShape = RoundedCornerShape(18.dp),
    contentAlignment: Alignment = Alignment.Center,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = minHeight)
            .clip(shape = shape)
            .background(color = bgColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                enabled = enabled
            ) {
                onClick()
            },
        contentAlignment = contentAlignment
    ) {
        content()
    }
}

@Composable
fun DefaultGradientButton(
    modifier: Modifier = Modifier,
    minHeight: Dp = 60.dp,
    bgColor: List<Pair<Float, Color>> = Theme.gradients.bgButtonLinear,
    shape: RoundedCornerShape = RoundedCornerShape(18.dp),
    contentAlignment: Alignment = Alignment.Center,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .defaultMinSize(minHeight = minHeight)
            .clip(shape = shape)
            .background(
                brush = Brush.linearGradient(
                    bgColor
                )
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = true),
                enabled = enabled
            ) {
                onClick()
            },
        contentAlignment = contentAlignment
    ) {
        content()
    }
}