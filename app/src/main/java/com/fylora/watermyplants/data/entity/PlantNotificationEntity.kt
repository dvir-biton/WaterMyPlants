package com.fylora.watermyplants.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fylora.watermyplants.core.Commons.NOTIFICATIONS_TABLE_NAME

@Entity(tableName = NOTIFICATIONS_TABLE_NAME)
data class PlantNotificationEntity(
    val body: String,
    val action: String,
    val plantId: Int?,
    val timestamp: Long,
    val isOpened: Boolean,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
