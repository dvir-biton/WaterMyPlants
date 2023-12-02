package com.fylora.watermyplants.data.data_sources

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fylora.watermyplants.data.entity.PlantEntity

@Dao
interface PlantsDao {
    @Query("SELECT * FROM plants")
    fun getAllPlants(): List<PlantEntity>

    @Query("SELECT * FROM plants WHERE id = :id")
    fun getPlantById(id: Int): PlantEntity?

    @Update
    fun updatePlant(plant: PlantEntity)

    @Delete
    fun deletePlant(id: Int)

    @Insert
    fun insertPlant(plant: PlantEntity)
}