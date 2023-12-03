package com.fylora.watermyplants.presentation.home_screen

import com.fylora.watermyplants.domain.model.Plant

sealed interface HomeEvents {
    data object AddNewPlant: HomeEvents
    data class DeletePlant(val id: Int): HomeEvents
    data class OnPlantClick(val id: Int): HomeEvents
    data class OnPlantUpdate(val plant: Plant): HomeEvents
}