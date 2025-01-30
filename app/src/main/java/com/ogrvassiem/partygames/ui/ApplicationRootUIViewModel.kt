package com.ogrvassiem.partygames.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogrvassiem.partygames.aplication.query.core.QueryDispatcher
import com.ogrvassiem.partygames.aplication.query.operations.GetShowOnboardingQuery
import com.ramcosta.composedestinations.spec.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplicationRootUIViewModel @Inject constructor(
    private val queryDispatcher: QueryDispatcher,
) : ViewModel() {
    var startDestination by mutableStateOf<Route?>(null)
        private set

    init {
        viewModelScope.launch {
            val shouldShowOnboarding = async {
                queryDispatcher.dispatch(GetShowOnboardingQuery).first()
            }
            startDestination = when {
                shouldShowOnboarding.await() -> OnboardingScreenDestination
                else -> MainSectionScreenDestination
            }
        }
    }
}