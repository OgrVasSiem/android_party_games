package com.ogrvassiem.partygames.ui.destination.startGame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ogrvassiem.partygames.R
import com.ogrvassiem.partygames.aplication.readModels.ListTeams
import com.ogrvassiem.partygames.ui.destination.startGame.presentation.ItemAttributesNavArgs
import com.ogrvassiem.partygames.ui.destination.startGame.presentation.StartGameNavigationAction
import com.ogrvassiem.partygames.ui.destination.startGame.presentation.StartGameViewModel
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination(navArgsDelegate = ItemAttributesNavArgs::class)
@RootNavGraph
fun StartGameScreen(
    viewModel: StartGameViewModel = hiltViewModel(),
    rootNavigator: RootNavigator,
) {
    val navigationAction = remember { StartGameNavigationAction(rootNavigator = rootNavigator) }
    val isGameFinished by viewModel.isGameFinished.collectAsState()
    val teams = viewModel.teams

    GameSettingsScreenUI(
        teamWithIdOne = viewModel.teamWithIdOne,
        isGameFinished = isGameFinished,
        teams = teams,
        navigateToGameScreen = {
            navigationAction.navigateToGameScreen(
                teamScoreList = viewModel.teamScoreList,
                categories = viewModel.categories
            )
        }
    )
}

@Composable
fun GameSettingsScreenUI(
    modifier: Modifier = Modifier,
    isGameFinished: Boolean,
    teamWithIdOne: ListTeams?,
    teams: List<ListTeams>,
    navigateToGameScreen: () -> Unit
) {
    Scaffold(
        containerColor = Theme.colors.bg,
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = {
            ButtonBottomBar(
                navigateToGameScreen = navigateToGameScreen
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (isGameFinished) {

            } else {
                item { Spacer(modifier = Modifier.height(40.dp)) }

                teamWithIdOne?.let { teams ->
                    item {
                        Box(modifier = Modifier.size(width = 600.dp, height = 183.dp)) {
                            Image(
                                painter = painterResource(id = teams.iconRes),
                                contentDescription = null,
                                modifier = Modifier
                                    .align(alignment = Center)
                                    .size(183.dp)
                            )
                        }
                    }
                }

                items(teams) { team ->
                    StartGameItem(
                        teams = team,
                        activeTeam = teamWithIdOne,
                    )
                }
            }
        }
    }
}

@Composable
private fun StartGameItem(
    teams: ListTeams,
    activeTeam: ListTeams?,
) {
    val isActive = teams == activeTeam

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        Image(
            painter = painterResource(id = teams.iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(66.dp)
                .alpha(if (isActive) 1f else 0.6f)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "${teams.firstTitle} ${teams.secondTitle}",
            color = Theme.colors.black,
            style = Theme.textStyles.bodyBold1,
            modifier = Modifier
                .align(alignment = CenterVertically)
                .alpha(if (isActive) 1f else 0.6f)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = teams.score.toString(),
            color = Theme.colors.black,
            style = Theme.textStyles.body1,
            modifier = Modifier.align(alignment = CenterVertically)
        )
    }
}

@Composable
private fun ButtonBottomBar(
    navigateToGameScreen: () -> Unit,
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
                    navigateToGameScreen()
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