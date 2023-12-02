package com.fylora.watermyplants.data.data_sources

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fylora.watermyplants.core.Commons.PLANTS_TABLE_NAME
import com.fylora.watermyplants.data.entity.PlantEntity

@Dao
interface PlantsDao {
    @Query("SELECT * FROM $PLANTS_TABLE_NAME")
    fun getAllPlants(): List<PlantEntity>

    @Query("SELECT * FROM $PLANTS_TABLE_NAME WHERE id = :id")
    fun getPlantById(id: Int): PlantEntity?

    @Update
    fun updatePlant(plant: PlantEntity)

    @Delete
    fun deletePlant(id: Int)

    @Insert
    fun insertPlant(plant: PlantEntity)
}