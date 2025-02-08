package com.ogrvassiem.partygames.ui.destination.onboarding

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ogrvassiem.partygames.ui.components.buttons.DefaultGradientTextButton
import com.ogrvassiem.partygames.ui.destination.onboarding.components.OnboardingPage
import com.ogrvassiem.partygames.ui.destination.onboarding.components.OnboardingPager
import com.ogrvassiem.partygames.ui.destination.onboarding.presentation.OnboardingNavigationActions
import com.ogrvassiem.partygames.ui.destination.onboarding.presentation.OnboardingViewModel
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ogrvassiem.partygames.ui.theme.Theme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import kotlinx.coroutines.launch

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
    val pagerState = rememberPagerState(pageCount = { OnboardingPage.entries.size })

    OnboardingBackHandler(pagerState = pagerState)

    Scaffold(
        containerColor = Theme.colors.bg
    ) { paddingValues ->
        OnboardingContent(
            modifier = Modifier.padding(paddingValues),
            pagerState = pagerState,
            navigateToSectionsScreen = navigationAction::navigateToMainScreen,
            updateShowOnboarding = viewModel::updateShowOnboarding
        )
    }
}

@Composable
private fun OnboardingContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    navigateToSectionsScreen: () -> Unit,
    updateShowOnboarding: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()

    val buttonText = OnboardingPage.entries[pagerState.currentPage].text3

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))

        OnboardingPager(pagerState = pagerState)

        Spacer(modifier = Modifier.height(21.dp))

        DefaultGradientTextButton(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 36.dp),
            text = buttonText,
            onClick = {
                if (pagerState.currentPage == pagerState.lastPage) {
                    updateShowOnboarding()
                    navigateToSectionsScreen()
                } else {
                    coroutineScope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        StaticPagerIndicator(pagerState = pagerState)

        Spacer(
            modifier = Modifier
                .navigationBarsPadding()
                .height(30.dp)
        )
    }
}

private val PagerState.lastPage: Int
    get() = pageCount - 1

@Composable
fun StaticPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    activeColor: Color = Color(0xFF5a5a5a),
    inactiveColor: Color = Color(0xFF5a5a5a).copy(alpha = 0.30f),
    indicatorWidth: Dp = 6.dp,
    indicatorHeight: Dp = 6.dp,
    spacing: Dp = 13.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        repeat(3) { index ->
            Box(
                modifier = Modifier
                    .padding(spacing / 2)
                    .size(indicatorWidth, indicatorHeight)
                    .background(
                        if (pagerState.currentPage == index) activeColor else inactiveColor,
                        CircleShape
                    )
            )
        }
    }
}

@Composable
private fun OnboardingBackHandler(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    BackHandler(enabled = pagerState.currentPage in (1..2)) {
        coroutineScope.launch {
            pagerState.animateScrollToPage(pagerState.currentPage - 1)
        }
    }
}