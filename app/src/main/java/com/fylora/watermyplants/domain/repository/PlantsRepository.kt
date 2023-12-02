package com.fylora.watermyplants.domain.repository

import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.model.PlantNotification

interface PlantsRepository {
    fun getAllPlants(): List<Plant>

    fun getPlantById(id: Int): Plant?

    fun updatePlant(plant: Plant)

    fun deletePlant(id: Int)

    fun insertPlant(plant: Plant)

    fun getAllNotifications(): List<PlantNotification>

    fun upsertNotification(notification: PlantNotification)
}