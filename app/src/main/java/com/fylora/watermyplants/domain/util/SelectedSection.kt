package com.fylora.watermyplants.domain.util

sealed class SelectedSection(val name: String) {
    data object Upcoming: SelectedSection("Upcoming")
    data object ForgotToWater: SelectedSection("Forgot to water")
    data object History: SelectedSection("History")
}