package com.ogrvassiem.partygames.ui.destination.mainSectionScreen.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import com.ogrvassiem.partygames.aplication.readModels.TopicsResponse
import com.ogrvassiem.partygames.ui.theme.Theme
import kotlinx.coroutines.delay

@Preview
@Composable
fun CategoryCardsPreview(modifier: Modifier = Modifier) {
    CategoryCards(
        card = TopicsResponse.Topics(
            name = "Jopa",
            color = "#F385C4",
            freeTopic = true,
            image = "category1",
            storeID = "",
            description = "",
            words = listOf(
                TopicsResponse.Topics.Complexity(
                    easy = listOf("", ""),
                    medium = listOf("", ""),
                    hard = listOf("", "")
                )
            )
        ),
        onCardClick = {},
        isSelected = false
    )
}

@Composable
fun CategoryCards(
    card: TopicsResponse.Topics,
    onCardClick: (String) -> Unit,
    isSelected: Boolean,
) {
    var isPressed by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val scale: Float by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = spring(),
        label = ""
    )

    val imageResId = remember(card.image) {
        context.resources.getIdentifier(
            card.image,
            "drawable",
            context.packageName
        )
    }
    val bordeColors = Theme.colors.redAccent

    val (borderStrokeWidth, borderColor) = remember(isSelected) {
        val width = if (isSelected) 3.dp else 1.dp
        val color = if (isSelected)
            bordeColors
        else Color(0xFFF2F2F8)
        width to color
    }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            delay(60)
            isPressed = false
        }
    }

    Box(
        modifier = Modifier
            .width((LocalConfiguration.current.screenWidthDp.dp - (4 * 8.dp)) / 2)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    isPressed = true
                    onCardClick(card.name)
                }
            )
            .border(
                width = borderStrokeWidth,
                color = borderColor,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(Color(android.graphics.Color.parseColor(card.color))),
        contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(imageResId),
            contentDescription = null,
        )

        Text(
            text = card.name,
            color = Theme.colors.white,
            style = Theme.textStyles.name,
            modifier = Modifier.padding(15.dp)
        )
    }

}