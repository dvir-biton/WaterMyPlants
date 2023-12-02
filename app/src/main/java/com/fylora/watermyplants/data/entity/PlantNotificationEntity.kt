package com.fylora.watermyplants.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notifications")
data class PlantNotificationEntity(
    val body: String,
    val action: String,
    val plantId: Int?,
    val timestamp: Long,
    val isOpened: Boolean,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
