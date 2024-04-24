package com.fylora.watermyplants.domain.model

import android.net.Uri
import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import java.time.LocalDate
import java.time.LocalTime

data class Plant(
    val name: String,
    val amountOfWater: Int,
    val description: String,
    val size: PlantSize,
    val time: LocalTime,
    val nextWater: LocalDate,
    val status: PlantStatus,
    val image: Uri,
    val id: Int?
)

class InvalidPlantException(message: String) : Exception(message)