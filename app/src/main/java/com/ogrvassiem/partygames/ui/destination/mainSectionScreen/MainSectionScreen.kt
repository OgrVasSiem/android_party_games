package com.ogrvassiem.partygames.ui.destination.mainSectionScreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ogrvassiem.partygames.ui.destination.mainSectionScreen.presentation.MainSectionViewModel
import com.ogrvassiem.partygames.ui.navGraphs.MainSectionNavGraph
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
@MainSectionNavGraph(start = true)
fun MainSectionScreen(
    viewModel: MainSectionViewModel = hiltViewModel(),
    rootNavigator: RootNavigator
) {

}