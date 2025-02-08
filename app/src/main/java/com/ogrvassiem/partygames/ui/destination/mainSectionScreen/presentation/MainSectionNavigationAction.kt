package com.ogrvassiem.partygames.ui.destination.mainSectionScreen.presentation

import com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation.CategoriesNavArgs
import com.ogrvassiem.partygames.ui.destinations.GameSettingsScreenDestination
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.utils.launchSingleTopNavigate

class MainSectionNavigationAction(
    val rootNavigator: RootNavigator
) {
    fun navigateToGameSettingsScreen(selectedCardsNames: List<String>){
        rootNavigator.launchSingleTopNavigate(
            GameSettingsScreenDestination(
                navArgs = CategoriesNavArgs(
                    categories = ArrayList(
                        selectedCardsNames
                    )
                )
            )
        )
    }
}