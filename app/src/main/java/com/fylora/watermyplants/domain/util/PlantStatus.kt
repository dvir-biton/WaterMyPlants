package com.fylora.watermyplants.domain.util

sealed class PlantStatus(val type: String) {
    data object Watered: PlantStatus("watered")
    data object Upcoming: PlantStatus("upcoming")
    data object ForgotToWater: PlantStatus("forgot_to_water")

    companion object {
        fun fromType(type: String): PlantStatus {
            return when (type.lowercase()) {
                "upcoming" -> Upcoming
                "forgot_to_water" -> ForgotToWater
                "watered" -> Watered
                else -> throw IllegalArgumentException("Unknown plant status type: $type")
            }
        }
    }
}