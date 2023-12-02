package com.fylora.watermyplants.data.data_sources

import android.app.Notification
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface PlantNotificationsDao {
    @Query("SELECT * FROM notifications")
    fun getAllNotifications(): List<Notification>

    @Upsert
    fun upsertNotification(notification: Notification)
}