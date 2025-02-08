package com.ogrvassiem.partygames.ui.destination.gameSettingsScreen.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogrvassiem.partygames.aplication.readModels.Complexity
import com.ogrvassiem.partygames.aplication.readModels.RoundTime
import com.ogrvassiem.partygames.aplication.readModels.VictoryPoints
import com.ogrvassiem.partygames.data.dataStore.ComplexityDataStore
import com.ogrvassiem.partygames.data.dataStore.PenaltyForSkippingDataStore
import com.ogrvassiem.partygames.data.dataStore.RoundTimeDataStore
import com.ogrvassiem.partygames.data.dataStore.VictoryPointsDataStore
import com.ogrvassiem.partygames.ui.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameSettingsViewModel @Inject constructor(
    private val complexityDataStore: ComplexityDataStore,
    private val victoryPointsDataStore: VictoryPointsDataStore,
    private val roundTimeDataStore: RoundTimeDataStore,
    private val penaltyForSkippingDataStore: PenaltyForSkippingDataStore,
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    val categories: List<String> = savedStateHandle.navArgs<CategoriesNavArgs>().categories

    val selectedVictoryPoints: StateFlow<VictoryPoints> = victoryPointsDataStore.data
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = VictoryPoints.TWENTY
        )

    val selectedRoundTime: StateFlow<RoundTime> = roundTimeDataStore.data
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = RoundTime.TWENTY
        )

    val selectedComplexities: StateFlow<List<Complexity>> = complexityDataStore.data
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = listOf(Complexity.EASY)
        )

    val isPenaltyForSkippingEnabled: StateFlow<Boolean> = penaltyForSkippingDataStore.data
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = true
        )

    fun setSelectedComplexities(selectedComplexities: List<Complexity>) {
        viewModelScope.launch {
            complexityDataStore.updateData { selectedComplexities }
        }
    }



    fun setVictoryPoints(newPoints: VictoryPoints) {
        viewModelScope.launch {
            victoryPointsDataStore.updateData { newPoints }
        }
    }

    fun setPenaltyForSkipping(enabled: Boolean) {
        viewModelScope.launch {
            penaltyForSkippingDataStore.updateData { enabled }
        }
    }

    fun setRoundTime(newTime: RoundTime) {
        viewModelScope.launch {
            roundTimeDataStore.updateData { newTime }
        }
    }
}