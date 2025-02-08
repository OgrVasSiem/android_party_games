package com.ogrvassiem.partygames.ui.destination.startGame.presentation

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogrvassiem.partygames.aplication.readModels.ListTeams
import com.ogrvassiem.partygames.aplication.readModels.TeamInfo
import com.ogrvassiem.partygames.aplication.readModels.TeamScore
import com.ogrvassiem.partygames.ui.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartGameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    val teams: List<ListTeams> =
        savedStateHandle.navArgs<ItemAttributesNavArgs>().attributes.listTeams()
    val categories: List<String> = savedStateHandle.navArgs<ItemAttributesNavArgs>().categories

    var teamWithIdOne = getFirstTeam()

    private val _isGameFinished = MutableStateFlow(false)
    val isGameFinished: StateFlow<Boolean> = _isGameFinished.asStateFlow()

    val teamScoreList: List<TeamScore>
        get() = listOfNotNull(teamWithIdOne?.let { team ->
            TeamScore(
                team.firstTitle,
                team.secondTitle,
                team.id,
                team.score,
                team.gameCount
            )
        }
        )

    fun finishGame(context: Context) {
        _isGameFinished.value = true
    }

    private fun getFirstTeam(): ListTeams? {
        return if (teams.isNotEmpty()) teams[0] else null
    }

    private fun List<TeamInfo>.listTeams(): List<ListTeams> {
        return this.map { teamInfo ->
            ListTeams(
                teamInfo.id,
                teamInfo.firstTitle,
                teamInfo.secondTitle,
                teamInfo.ending,
                teamInfo.iconRes,
                gameCount = 0,
                score = 0
            )
        }
    }
}