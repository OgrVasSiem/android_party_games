package com.ogrvassiem.partygames.ui.destination.gameScreen.presentation

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogrvassiem.partygames.aplication.readModels.GameAtributesNavArgs
import com.ogrvassiem.partygames.aplication.readModels.TeamScore
import com.ogrvassiem.partygames.data.dataStore.ComplexityDataStore
import com.ogrvassiem.partygames.data.dataStore.RoundTimeDataStore
import com.ogrvassiem.partygames.ui.navArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val roundTimeDataStore: RoundTimeDataStore,
) : ViewModel() {

    val categories: List<String> = savedStateHandle.navArgs<GameAtributesNavArgs>().categories
    val currentCommand: List<TeamScore> =
        savedStateHandle.navArgs<GameAtributesNavArgs>().currentCommand

    private val _isTimerRunning = MutableStateFlow(false)
    val isTimerRunning: StateFlow<Boolean> = _isTimerRunning.asStateFlow()

    private val _timeLeft = MutableStateFlow(0L)
    val timeLeft: StateFlow<Long> = _timeLeft.asStateFlow()

    private val _isTimerFinished = MutableStateFlow(false)
    val isTimerFinished: StateFlow<Boolean> = _isTimerFinished.asStateFlow()

    private val _initialTime = MutableStateFlow(0L)
    val initialTime: StateFlow<Long> = _initialTime.asStateFlow()

    private var timerJob: Job? = null

    init {
        viewModelScope.launch {
            roundTimeDataStore.data.collect { roundTime ->
                val timeInMillis = roundTime.time * 1000L
                _timeLeft.value = timeInMillis
                _initialTime.value = timeInMillis
            }
        }
    }

    fun startTimer() {
        if (_isTimerRunning.value) return

        _isTimerRunning.value = true
        timerJob = viewModelScope.launch {
            while (_timeLeft.value > 0 && _isTimerRunning.value) {
                delay(1000)
                _timeLeft.value -= 1000
            }
            if (_timeLeft.value <= 0) {
                _isTimerFinished.value = true
            }
        }
    }

    fun pauseTimer() {
        _isTimerRunning.value = false
        timerJob?.cancel()
    }

    fun resetTimer() {
        viewModelScope.launch {
            _timeLeft.value = _initialTime.value
            _isTimerRunning.value = false
            _isTimerFinished.value = false
        }
    }
}
