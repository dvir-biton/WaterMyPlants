package com.fylora.watermyplants.domain.model

import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import java.net.URI
import java.time.LocalDate
import java.time.LocalTime

data class Plant(
    val plantName: String,
    val amountOfWater: Int,
    val description: String,
    val size: PlantSize,
    val time: LocalTime,
    val nextWater: LocalDate,
    val status: PlantStatus,
    val image: URI
)
