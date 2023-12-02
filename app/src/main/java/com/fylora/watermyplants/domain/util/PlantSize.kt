package com.fylora.watermyplants.domain.util

sealed interface PlantSize {
    data object Small: PlantSize
    data object Medium: PlantSize
    data object Large: PlantSize
    data object ExtraLarge: PlantSize
}