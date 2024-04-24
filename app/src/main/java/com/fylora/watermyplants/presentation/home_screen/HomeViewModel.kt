package com.fylora.watermyplants.presentation.home_screen

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fylora.watermyplants.core.Route
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.repository.PlantsRepository
import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import com.fylora.watermyplants.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PlantsRepository
): ViewModel() {

    private var _state = mutableStateOf(HomeState())
    val state = _state

    private var _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent

    init {
        viewModelScope.launch {
            repository.getAllPlants().collect {
                _state.value = _state.value.copy(
                    plants = it
                )
            }
        }

        if(state.value.plants.isEmpty()) {
            val plant = Plant(
                name = "Aurora Norton",
                amountOfWater = 125,
                description = "This is my plant",
                size = PlantSize.Medium,
                time = LocalTime.now(),
                nextWater = LocalDate.now().plusDays(3),
                status = PlantStatus.Watered,
                image = Uri.parse("https://t4.ftcdn.net/jpg/01/79/88/65/360_F_179886510_6xf0RHhDnLN5ovd2qmGF4WaZMJjqrt6o.jpg"),
                id = 1
            )

            viewModelScope.launch {
                repository.upsertPlant(plant)
                repository.upsertPlant(plant.copy(name = "My Favorite", id = 2))
                repository.upsertPlant(plant.copy(name = "My Little Favorite", id = 3))
            }
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
                    repository.deletePlant(event.plant)
                }
                is HomeEvents.OnPlantClick -> {
                    _uiEvent.send(
                        UiEvent.Navigate(
                            Route.PLANT_DETAILS_SCREEN + "/${event.id}"
                        )
                    )
                }
                is HomeEvents.OnPlantUpdate -> {
                    repository.upsertPlant(event.plant)
                }
                is HomeEvents.OnSectionChange -> {
                    _state.value = state.value.copy(
                        selectedSection = event.section
                    )
                }
                HomeEvents.NavigateToNotifications -> {
                    _uiEvent.send(
                        UiEvent.Navigate(
                            Route.NOTIFICATIONS_SCREEN
                        )
                    )
                }
                is HomeEvents.UpdatePlantStatus -> {
                    val newStatus = when (event.plant.status) {
                        PlantStatus.Upcoming, PlantStatus.ForgotToWater -> PlantStatus.Watered
                        else -> if (event.plant.nextWater.isBefore(LocalDate.now())) PlantStatus.ForgotToWater else PlantStatus.Upcoming
                    }

                    repository.upsertPlant(event.plant.copy(status = newStatus))
                }
            }
        }
    }
}