package com.ogrvassiem.partygames.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object Theme {

    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val gradients: Gradients
        @Composable
        @ReadOnlyComposable
        get() = LocalGradients.current

    val textStyles: TextStyles
        @Composable
        @ReadOnlyComposable
        get() = LocalTextStyles.current
}

@Composable
fun Theme(content: @Composable () -> Unit) {
    val rippleIndication = ripple()

    CompositionLocalProvider(
        LocalIndication provides rippleIndication,
    ) {
        content()
    }
}