package com.ogrvassiem.partygames.ui.destination.startGame.presentation

import com.ogrvassiem.partygames.aplication.readModels.GameAtributesNavArgs
import com.ogrvassiem.partygames.aplication.readModels.TeamScore
import com.ogrvassiem.partygames.ui.destinations.GameScreenDestination
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.utils.launchSingleTopNavigate

class StartGameNavigationAction(
    val rootNavigator: RootNavigator
) {
    fun navigateToGameScreen(teamScoreList: List<TeamScore>, categories: List<String>) {
        rootNavigator.launchSingleTopNavigate(
            GameScreenDestination(
                navArgs = GameAtributesNavArgs(
                    currentCommand = ArrayList(teamScoreList),
                    categories = ArrayList(categories),
                )
            )
        )
    }
}