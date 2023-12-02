package com.fylora.watermyplants.data.data_sources

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fylora.watermyplants.data.entity.PlantEntity
import com.fylora.watermyplants.data.entity.PlantNotificationEntity

@Database(
    entities = [PlantEntity::class, PlantNotificationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PlantsDatabase: RoomDatabase() {
    abstract val plantsDao: PlantsDao
    abstract val plantNotificationDao: PlantNotificationsDao
}