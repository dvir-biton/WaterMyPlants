package com.fylora.watermyplants.domain.repository

import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.model.PlantNotification
import kotlinx.coroutines.flow.Flow

interface PlantsRepository {
    fun getAllPlants(): Flow<List<Plant>>

    suspend fun getPlantById(id: Int): Plant?

    suspend fun deletePlant(plant: Plant)

    suspend fun upsertPlant(plant: Plant)

    suspend fun getAllNotifications(): List<PlantNotification>

    suspend fun upsertNotification(notification: PlantNotification)
}