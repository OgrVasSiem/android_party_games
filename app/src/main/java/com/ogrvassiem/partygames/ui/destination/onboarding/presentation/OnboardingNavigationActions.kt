package com.ogrvassiem.partygames.ui.destination.onboarding.presentation

import com.ogrvassiem.partygames.ui.destinations.MainSectionScreenDestination
import com.ogrvassiem.partygames.ui.destinations.OnboardingScreenDestination
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.utils.launchSingleTopNavigate

class OnboardingNavigationActions(
    private val rootNavigator: RootNavigator
) {
    fun navigateToMainScreen() {
        rootNavigator.launchSingleTopNavigate(MainSectionScreenDestination()) {
            popUpTo(route = OnboardingScreenDestination.route) { inclusive = true }
        }
    }
}