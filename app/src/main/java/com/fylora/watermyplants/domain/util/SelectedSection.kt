package com.fylora.watermyplants.domain.util

sealed class SelectedSection(
    val name: String,
    val status: PlantStatus
) {
    data object Upcoming: SelectedSection("Upcoming", PlantStatus.Upcoming)
    data object ForgotToWater: SelectedSection("Forgot to water", PlantStatus.ForgotToWater)
    data object History: SelectedSection("History", PlantStatus.Watered)
}