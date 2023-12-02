package com.fylora.watermyplants.domain.util

sealed interface PlantStatus {
    data object Watered: PlantStatus
    data object Upcoming: PlantStatus
    data object ForgotToWater: PlantStatus
}