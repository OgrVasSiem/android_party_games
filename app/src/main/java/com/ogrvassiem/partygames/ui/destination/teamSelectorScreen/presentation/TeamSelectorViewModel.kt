package com.ogrvassiem.partygames.ui.destination.teamSelectorScreen.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ogrvassiem.partygames.aplication.readModels.TeamInfo
import com.ogrvassiem.partygames.aplication.utils.TeamNameGenerator
import com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation.CategoriesNavArgs
import com.ogrvassiem.partygames.ui.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class TeamSelectorViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val categories: List<String> = savedStateHandle.navArgs<CategoriesNavArgs>().categories


    private val _teams = MutableStateFlow(
        listOf(
            TeamNameGenerator().generateTeam(),
            TeamNameGenerator().generateTeam()
        )
    )
    val teams: StateFlow<List<TeamInfo>> = _teams.asStateFlow()

    fun addTeam() {
        _teams.value += TeamNameGenerator().generateTeam()
    }

    fun removeTeam(team: TeamInfo) {
        _teams.value = _teams.value.filter { it != team }
    }
}