package com.fylora.watermyplants.presentation.home_screen

import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.util.SelectedSection

data class HomeState(
    val plants: List<Plant> = emptyList(),
    val isDeleteDialogVisible: Boolean = false,
    val selectedSection: SelectedSection = SelectedSection.Upcoming
)
