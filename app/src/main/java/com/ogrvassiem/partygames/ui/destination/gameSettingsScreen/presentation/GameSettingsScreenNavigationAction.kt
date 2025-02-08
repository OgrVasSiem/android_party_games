package com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation

import com.ogrvassiem.partygames.ui.destinations.GameSettingsScreenDestination
import com.ogrvassiem.partygames.ui.destinations.TeamSelectorScreenDestination
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.utils.launchSingleTopNavigate

class GameSettingsScreenNavigationAction(
    val rootNavigator: RootNavigator
) {
    fun navigateToTemSelectorScreen(selectedCardsNames: List<String>){
        rootNavigator.launchSingleTopNavigate(
            TeamSelectorScreenDestination(
                navArgs = CategoriesNavArgs(
                    categories = ArrayList(
                        selectedCardsNames
                    )
                )
            )
        )
    }
}