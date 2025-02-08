package com.ogrvassiem.partygames.ui.destination.mainSectionScreen.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ogrvassiem.partygames.aplication.readModels.TopicsResponse
import com.ogrvassiem.partygames.di.JsonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainSectionViewModel @Inject constructor(
    private val jsonRepository: JsonRepository
) : ViewModel() {
    private val _topics = MutableStateFlow<List<TopicsResponse.Topics>>(emptyList())
    val topics = _topics.asStateFlow()

    private val _selectedCardsNames = MutableStateFlow<List<String>>(emptyList())
    val selectedCardsNames: StateFlow<List<String>> = _selectedCardsNames.asStateFlow()

    init {
        viewModelScope.launch {
            start()
            Log.d("MainSectionViewModel", "${topics.value}")
        }
    }

    private fun start(){
        val topicsResponse = jsonRepository.readJsonFromResources()
        _topics.value = topicsResponse?.topics ?: emptyList()

    }

    fun toggleCardSelection(cardName: String) {
        val currentNames = _selectedCardsNames.value
        _selectedCardsNames.value = if (currentNames.contains(cardName)) {
            currentNames.filter { it != cardName }
        } else {
            currentNames + cardName
        }
    }
}