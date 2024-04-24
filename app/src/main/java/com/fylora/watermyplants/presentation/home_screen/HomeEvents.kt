package com.fylora.watermyplants.presentation.home_screen

import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.util.SelectedSection

sealed interface HomeEvents {
    data object AddNewPlant: HomeEvents
    data object NavigateToNotifications: HomeEvents
    data class UpdatePlantStatus(val plant: Plant): HomeEvents
    data class DeletePlant(val plant: Plant): HomeEvents
    data class OnPlantClick(val id: Int): HomeEvents
    data class OnPlantUpdate(val plant: Plant): HomeEvents
    data class OnSectionChange(val section: SelectedSection): HomeEvents
}