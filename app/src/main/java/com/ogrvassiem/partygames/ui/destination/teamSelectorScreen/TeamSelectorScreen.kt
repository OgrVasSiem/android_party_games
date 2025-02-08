package com.ogrvassiem.partygames.ui.destination.teamSelectorScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.ogrvassiem.partygames.R
import com.ogrvassiem.partygames.aplication.readModels.TeamInfo
import com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation.CategoriesNavArgs
import com.ogrvassiem.partygames.ui.destination.teamSelectorScreen.presentation.TeamSelectorNavigationAction
import com.ogrvassiem.partygames.ui.destination.teamSelectorScreen.presentation.TeamSelectorViewModel
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination(navArgsDelegate = CategoriesNavArgs::class)
@RootNavGraph
fun TeamSelectorScreen(
    viewModel: TeamSelectorViewModel = hiltViewModel(),
    rootNavigator: RootNavigator,
) {
    val teams by viewModel.teams.collectAsState()

    val navigationAction = remember { TeamSelectorNavigationAction(rootNavigator = rootNavigator) }

    TeamSelectorScreenUI(
        teams = teams,
        onAddTeam = viewModel::addTeam,
        onRemoveTeam = viewModel::removeTeam,
        navigateToStartGameScreen = {
            navigationAction.navigateToStartGameScreen(
                teamsOnScreen = teams,
                categories = viewModel.categories
            )
        }
    )
}


@Composable
fun TeamSelectorScreenUI(
    teams: List<TeamInfo>,
    onAddTeam: () -> Unit,
    onRemoveTeam: (TeamInfo) -> Unit,
    navigateToStartGameScreen: ()->  Unit
) {
    Scaffold(
        containerColor = Theme.colors.bg,
        bottomBar = {
            ButtonBottomBar(
                navigateToStartGameScreen = navigateToStartGameScreen,
                teams = teams
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { Spacer(modifier = Modifier.height(20.dp)) }

            items(teams) { team ->
                TeamItem(team, onRemove = { onRemoveTeam(team) })
            }

            item {
                TeamActionItem(
                    text = "Добавить команду",
                    color = Theme.colors.accent,
                    onClick = onAddTeam
                )
            }
        }
    }
}

@Composable
fun TeamItem(team: TeamInfo, onRemove: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Theme.colors.card)
            .height(140.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(team.iconRes),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(96.dp)
                        .background(Color.LightGray)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "${team.firstTitle} ${team.secondTitle}",
                        style = Theme.textStyles.name
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = team.ending,
                        style = Theme.textStyles.body1,
                        color = Theme.colors.textGray
                    )
                }
            }

            IconButton(
                onClick = onRemove,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_close_24),
                    contentDescription = "Удалить команду",
                    tint = Color.Black
                )
            }
        }
    }
}


@Composable
fun TeamActionItem(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .clickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                color = Color.White,
                style = Theme.textStyles.name
            )
        }
    }
}

@Composable
private fun ButtonBottomBar(
    navigateToStartGameScreen: () -> Unit,
    teams: List<TeamInfo>
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
                   if (teams.isNotEmpty()) { navigateToStartGameScreen() }
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