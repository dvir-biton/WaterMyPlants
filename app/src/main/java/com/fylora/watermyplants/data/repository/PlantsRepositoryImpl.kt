package com.fylora.watermyplants.data.repository

import com.fylora.watermyplants.data.data_sources.PlantNotificationsDao
import com.fylora.watermyplants.data.data_sources.PlantsDao
import com.fylora.watermyplants.data.mappers.toEntity
import com.fylora.watermyplants.data.mappers.toModel
import com.fylora.watermyplants.domain.model.InvalidPlantException
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.model.PlantNotification
import com.fylora.watermyplants.domain.repository.PlantsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PlantsRepositoryImpl(
    private val plantsDao: PlantsDao,
    private val plantNotificationsDao: PlantNotificationsDao
): PlantsRepository {
    override fun getAllPlants(): Flow<List<Plant>> {
        return plantsDao.getAllPlants().map { plants ->
            plants.map { it.toModel() }
        }
    }

    override suspend fun getPlantById(id: Int): Plant? {
        return plantsDao.getPlantById(id)?.toModel()
    }


    override suspend fun deletePlant(plant: Plant) {
        plantsDao.deletePlant(plant.toEntity())
    }

    override suspend fun upsertPlant(plant: Plant) {
        if(plant.name.isBlank())
            throw InvalidPlantException("Plant name cannot be blank")

        if (plant.description.isBlank())
            throw InvalidPlantException("Plant description cannot be blank")

        plantsDao.upsertPlant(plant.toEntity())
    }

    override suspend fun getAllNotifications(): List<PlantNotification> {
        return plantNotificationsDao.getNotifications().map {
            it.toModel()
        }
    }

    override suspend fun upsertNotification(notification: PlantNotification) {
        plantNotificationsDao.upsertNotification(notification.toEntity())
    }
}