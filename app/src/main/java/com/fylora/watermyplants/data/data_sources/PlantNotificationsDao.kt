package com.fylora.watermyplants.data.data_sources

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.fylora.watermyplants.core.Commons.NOTIFICATIONS_TABLE_NAME
import com.fylora.watermyplants.data.entity.PlantNotificationEntity

@Dao
interface PlantNotificationsDao {
    @Query("SELECT * FROM $NOTIFICATIONS_TABLE_NAME")
    fun getNotifications(): List<PlantNotificationEntity>

    @Upsert
    fun upsertNotification(notification: PlantNotificationEntity)
}