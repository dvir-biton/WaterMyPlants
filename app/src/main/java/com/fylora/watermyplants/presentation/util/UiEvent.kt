package com.fylora.watermyplants.presentation.util

sealed interface UiEvent {
    data class ShowSnackBar(val message: String): UiEvent
    data class Navigate(val route: String): UiEvent
}