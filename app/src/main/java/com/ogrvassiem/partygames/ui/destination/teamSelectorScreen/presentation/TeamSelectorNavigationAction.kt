package com.ogrvassiem.partygames.ui.destination.teamSelectorScreen.presentation

import com.ogrvassiem.partygames.aplication.readModels.TeamInfo
import com.ogrvassiem.partygames.ui.destination.startGame.presentation.ItemAttributesNavArgs
import com.ogrvassiem.partygames.ui.destinations.StartGameScreenDestination
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.utils.launchSingleTopNavigate

class TeamSelectorNavigationAction(
    val rootNavigator: RootNavigator
) {
    fun navigateToStartGameScreen(teamsOnScreen: List<TeamInfo>, categories: List<String>) {
        rootNavigator.launchSingleTopNavigate(
            StartGameScreenDestination(
                navArgs = ItemAttributesNavArgs(
                    attributes = ArrayList(teamsOnScreen),
                    categories = ArrayList(categories)
                )
            )
        )
    }


}