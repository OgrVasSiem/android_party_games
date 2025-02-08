package com.ogrvassiem.partygames.ui.destination.gameSettingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import com.ogrvassiem.partygames.aplication.readModels.Complexity
import com.ogrvassiem.partygames.aplication.readModels.RoundTime
import com.ogrvassiem.partygames.aplication.readModels.VictoryPoints
import com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation.CategoriesNavArgs
import com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation.GameSettingsScreenNavigationAction
import com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation.GameSettingsViewModel
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination(navArgsDelegate = CategoriesNavArgs::class)
@RootNavGraph
fun GameSettingsScreen(
    viewModel: GameSettingsViewModel = hiltViewModel(),
    rootNavigator: RootNavigator,
) {
    val navigationAction =
        remember { GameSettingsScreenNavigationAction(rootNavigator = rootNavigator) }


    GameSettingsScreenUI(
        viewModel = viewModel,
        navigateToTeamSelector = { navigationAction.navigateToTemSelectorScreen(ArrayList(viewModel.categories)) })
}

@Composable
private fun GameSettingsScreenUI(
    viewModel: GameSettingsViewModel,
    navigateToTeamSelector: () -> Unit
) {
    val selectedComplexities by viewModel.selectedComplexities.collectAsState()
    val selectedRoundTime by viewModel.selectedRoundTime.collectAsState()
    val selectedVictoryPoints by viewModel.selectedVictoryPoints.collectAsState()
    val isPenaltyForSkippingEnabled by viewModel.isPenaltyForSkippingEnabled.collectAsState()

    Scaffold(
        containerColor = Theme.colors.bg,
        bottomBar = {
            ButtonBottomBar(
                navigateToChoiceCommand = navigateToTeamSelector,
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .imePadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = stringResource(R.string.choice_complexity),
                style = Theme.textStyles.body1
            )

            ComplexityPicker(
                selectedComplexities = selectedComplexities,
                onSelectionChange = viewModel::setSelectedComplexities
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.choice_time),
                style = Theme.textStyles.body1
            )

            RoundTimePicker(
                selectedTime = selectedRoundTime,
                onSelectionChange = viewModel::setRoundTime
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.choice_victory_points),
                style = Theme.textStyles.body1
            )

            VictoryPointsPicker(
                selectedPoints = selectedVictoryPoints,
                onSelectionChange = viewModel::setVictoryPoints
            )

            Spacer(modifier = Modifier.height(16.dp))

            PenaltyForSkippingPicker(
                isPenaltyEnabled = isPenaltyForSkippingEnabled,
                onToggleChange = viewModel::setPenaltyForSkipping
            )

        }
    }
}

@Composable
fun PenaltyForSkippingPicker(
    isPenaltyEnabled: Boolean,
    onToggleChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(100.dp),
                color = Theme.colors.accent
            )
            .clickable {
                onToggleChange(!isPenaltyEnabled)
            }
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.penalty_for_skipping),
            style = Theme.textStyles.bodyBold1,
            color = Theme.colors.black,
            modifier = Modifier.padding(start = 16.dp)
        )

        Switch(
            checked = isPenaltyEnabled,
            onCheckedChange = { onToggleChange(it) },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Theme.colors.white,
                checkedTrackColor = Theme.colors.accent,
                uncheckedThumbColor = Theme.colors.white,
                uncheckedTrackColor = Theme.colors.textOnboarding
            ),
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}


@Composable
fun ComplexityPicker(
    selectedComplexities: List<Complexity>,
    onSelectionChange: (List<Complexity>) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(100.dp),
                color = Theme.colors.accent
            ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Complexity.entries.forEach { complexity ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(if (complexity in selectedComplexities) Theme.colors.accent else Theme.colors.white)
                    .padding(vertical = 10.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) {
                        val newSelection = if (complexity in selectedComplexities) {
                            selectedComplexities - complexity
                        } else {
                            selectedComplexities + complexity
                        }
                        onSelectionChange(newSelection)
                    },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(complexity.resourceId),
                    color = if (complexity in selectedComplexities) Theme.colors.white else Theme.colors.black,
                    style = Theme.textStyles.body1,
                )
            }
        }
    }
}

@Composable
fun RoundTimePicker(
    selectedTime: RoundTime,
    onSelectionChange: (RoundTime) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(100.dp),
                color = Theme.colors.accent
            ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        RoundTime.entries.forEach { time ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(if (time == selectedTime) Theme.colors.accent else Theme.colors.white)
                    .padding(vertical = 10.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) {
                        onSelectionChange(time)
                    },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${time.time} сек",
                    color = if (time == selectedTime) Theme.colors.white else Theme.colors.black,
                    style = Theme.textStyles.body1,
                )
            }
        }
    }
}

@Composable
fun VictoryPointsPicker(
    selectedPoints: VictoryPoints,
    onSelectionChange: (VictoryPoints) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(100.dp),
                color = Theme.colors.accent
            ),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        VictoryPoints.entries.forEach { points ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(if (points == selectedPoints) Theme.colors.accent else Theme.colors.white)
                    .padding(vertical = 10.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                    ) {
                        onSelectionChange(points)
                    },
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${points.points} очков",
                    color = if (points == selectedPoints) Theme.colors.white else Theme.colors.black,
                    style = Theme.textStyles.body1,
                )
            }
        }
    }
}


@Composable
private fun ButtonBottomBar(
    navigateToChoiceCommand: () -> Unit,
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
                    navigateToChoiceCommand()
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