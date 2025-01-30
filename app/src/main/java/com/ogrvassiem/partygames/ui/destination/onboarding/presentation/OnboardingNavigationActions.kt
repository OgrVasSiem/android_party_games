package com.ogrvassiem.partygames.ui.destination.onboarding.presentation

import com.foresko.gptChat.ui.destinations.OnboardingScreenDestination
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.utils.launchSingleTopNavigate

class OnboardingNavigationActions(
    private val rootNavigator: RootNavigator
) {
    fun navigateToEnterPhoneScreen() {
        rootNavigator.launchSingleTopNavigate(MainSectionScreenDestination) {
            popUpTo(route = OnboardingScreenDestination.route) { inclusive = true }
        }
    }
}