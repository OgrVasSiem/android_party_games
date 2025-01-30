package com.ogrvassiem.partygames.ui.destination.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogrvassiem.partygames.aplication.command.core.CommandDispatcher
import com.ogrvassiem.partygames.aplication.command.operations.UpdateShowOnboardingCommand
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val commandDispatcher: CommandDispatcher
) : ViewModel() {
    fun updateShowOnboarding() {
        viewModelScope.launch {
            commandDispatcher.dispatch(UpdateShowOnboardingCommand)
        }
    }
}