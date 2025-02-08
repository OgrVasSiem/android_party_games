package com.ogrvassiem.partygames.ui.destination.mainSectionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ogrvassiem.partygames.R
import com.ogrvassiem.partygames.aplication.readModels.TopicsResponse
import com.ogrvassiem.partygames.ui.destination.mainSectionScreen.components.CategoryCards
import com.ogrvassiem.partygames.ui.destination.mainSectionScreen.presentation.MainSectionNavigationAction
import com.ogrvassiem.partygames.ui.destination.mainSectionScreen.presentation.MainSectionViewModel
import com.ogrvassiem.partygames.ui.destination.onboarding.presentation.OnboardingNavigationActions
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination
@RootNavGraph(start = true)
fun MainSectionScreen(
    viewModel: MainSectionViewModel = hiltViewModel(),
    rootNavigator: RootNavigator
) {
    val topics by viewModel.topics.collectAsState()

    val navigationAction = remember { MainSectionNavigationAction(rootNavigator = rootNavigator) }


    val selectedCardsNames by viewModel.selectedCardsNames.collectAsState()

    MainSectionScreenUI(
        topics = topics,
        selectedCardsNames = selectedCardsNames,
        onCardClick = viewModel::toggleCardSelection,
        navigateToGameSettingsScreen = {
            navigationAction.navigateToGameSettingsScreen(
                selectedCardsNames = selectedCardsNames
            )
        }
    )
}

@Composable
private fun MainSectionScreenUI(
    topics: List<TopicsResponse.Topics>,
    selectedCardsNames: List<String>,
    onCardClick: (String) -> Unit,
    navigateToGameSettingsScreen: () -> Unit,
) {
    Scaffold(
        containerColor = Theme.colors.bg,
        bottomBar = {
            if (selectedCardsNames.isNotEmpty()) {
                ButtonBottomBar(
                    navigateToGameSettingsScreen = navigateToGameSettingsScreen,
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .imePadding()
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 8.dp),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                items(topics) { card ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        val isSelected = card.name in selectedCardsNames
                        CategoryCards(
                            card = card,
                            onCardClick = { onCardClick(card.name) },
                            isSelected = isSelected,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ButtonBottomBar(
    navigateToGameSettingsScreen: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Theme.colors.textOnboarding)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 18.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(18.dp)
                )
                .background(Theme.colors.accent)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                ) {
                    navigateToGameSettingsScreen()
                },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(R.string.in_game),
                style = Theme.textStyles.name,
                color = Theme.colors.white,
                modifier = Modifier.padding(vertical = 18.dp),
            )
        }
    }
}
