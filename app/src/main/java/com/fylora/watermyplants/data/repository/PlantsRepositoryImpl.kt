package com.fylora.watermyplants.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.fylora.watermyplants.data.data_sources.PlantNotificationsDao
import com.fylora.watermyplants.data.data_sources.PlantsDao
import com.fylora.watermyplants.data.mappers.toEntity
import com.fylora.watermyplants.data.mappers.toModel
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.model.PlantNotification
import com.fylora.watermyplants.domain.repository.PlantsRepository

@RequiresApi(Build.VERSION_CODES.O)
class PlantsRepositoryImpl(
    private val plantsDao: PlantsDao,
    private val plantNotificationsDao: PlantNotificationsDao
): PlantsRepository {
    override fun getAllPlants(): List<Plant> {
        return plantsDao.getAllPlants().map {
            it.toModel()
        }
    }

    override fun getPlantById(id: Int): Plant? {
        return plantsDao.getPlantById(id)?.toModel()
    }

    override fun updatePlant(plant: Plant) {
        plantsDao.updatePlant(plant.toEntity())
    }

    override fun deletePlant(id: Int) {
        plantsDao.deletePlant(id)
    }

    override fun insertPlant(plant: Plant) {
        plantsDao.insertPlant(plant.toEntity())
    }

    override fun getAllNotifications(): List<PlantNotification> {
        return plantNotificationsDao.getNotifications().map {
            it.toModel()
        }
    }

    override fun upsertNotification(notification: PlantNotification) {
        plantNotificationsDao.upsertNotification(notification.toEntity())
    }
}