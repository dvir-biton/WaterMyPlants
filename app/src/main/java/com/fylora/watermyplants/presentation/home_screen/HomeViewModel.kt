package com.fylora.watermyplants.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylora.watermyplants.core.Route
import com.fylora.watermyplants.domain.repository.PlantsRepository
import com.fylora.watermyplants.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PlantsRepository
): ViewModel() {

    private var _state by mutableStateOf(HomeState())
    val state = _state

    private var _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent

    init {
        viewModelScope.launch {
            _state = _state.copy(
                plants = repository.getAllPlants()
            )
        }
    }

    fun onEvent(event: HomeEvents) {
        viewModelScope.launch {
            when(event) {
                HomeEvents.AddNewPlant -> {
                    _uiEvent.send(
                        UiEvent.Navigate(
                            Route.PLANT_DETAILS_SCREEN
                        )
                    )
                }
                is HomeEvents.DeletePlant -> {
                    repository.deletePlant(event.id)
                }
                is HomeEvents.OnPlantClick -> {
                    _uiEvent.send(
                        UiEvent.Navigate(
                            Route.PLANT_DETAILS_SCREEN + "/${event.id}"
                        )
                    )
                }
                is HomeEvents.OnPlantUpdate -> {
                    repository.updatePlant(event.plant)
                }
            }
        }
    }
}