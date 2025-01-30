package com.ogrvassiem.partygames.ui.destination.onboarding

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.ogrvassiem.partygames.ui.destination.onboarding.presentation.OnboardingNavigationActions
import com.ogrvassiem.partygames.ui.destination.onboarding.presentation.OnboardingViewModel
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination
@RootNavGraph
fun OnboardingScreen(
    rootNavigator: RootNavigator,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val navigationAction = remember { OnboardingNavigationActions(rootNavigator = rootNavigator) }

    OnboardingScreen(
        navigationAction = navigationAction,
        viewModel = viewModel
    )
}

@Composable
fun OnboardingScreen(
    navigationAction: OnboardingNavigationActions,
    viewModel: OnboardingViewModel
) {

}