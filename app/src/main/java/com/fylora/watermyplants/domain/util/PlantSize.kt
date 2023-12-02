package com.fylora.watermyplants.domain.util

sealed class PlantSize(val type: String) {
    data object Small: PlantSize("small")
    data object Medium: PlantSize("medium")
    data object Large: PlantSize("large")
    data object ExtraLarge: PlantSize("extra_large")

    companion object {
        fun fromType(type: String): PlantSize {
            return when (type.lowercase()) {
                "small" -> Small
                "medium" -> Medium
                "large" -> Large
                "extra_large" -> ExtraLarge
                else -> throw IllegalArgumentException("Unknown plant size type: $type")
            }
        }
    }
}