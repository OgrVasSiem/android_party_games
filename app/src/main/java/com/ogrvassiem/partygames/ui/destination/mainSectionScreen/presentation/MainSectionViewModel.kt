package com.ogrvassiem.partygames.ui.destination.mainSectionScreen.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.ogrvassiem.partygames.aplication.query.core.QueryDispatcher
import com.ogrvassiem.partygames.ui.navGraphs.MainSectionNavGraph
import com.ogrvassiem.partygames.ui.navGraphs.RootNavigator
import com.ramcosta.composedestinations.annotation.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainSectionViewModel @Inject constructor(
    private val queryDispatcher: QueryDispatcher,
) : ViewModel() {

}