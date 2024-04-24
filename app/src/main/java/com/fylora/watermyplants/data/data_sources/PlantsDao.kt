package com.fylora.watermyplants.data.data_sources

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.fylora.watermyplants.core.Commons.PLANTS_TABLE_NAME
import com.fylora.watermyplants.data.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantsDao {
    @Query("SELECT * FROM $PLANTS_TABLE_NAME")
    fun getAllPlants(): Flow<List<PlantEntity>>

    @Query("SELECT * FROM $PLANTS_TABLE_NAME WHERE id = :id")
    suspend fun getPlantById(id: Int): PlantEntity?

    @Delete
    suspend fun deletePlant(plant: PlantEntity)

    @Upsert
    suspend fun upsertPlant(plant: PlantEntity)
}