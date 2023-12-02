package com.fylora.watermyplants.domain.model

import java.time.LocalDateTime

data class PlantNotification(
    val body: String,
    val plantId: Int?,
    val timestamp: LocalDateTime,
    val isOpened: Boolean
)
