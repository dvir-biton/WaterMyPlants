package com.fylora.watermyplants.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fylora.watermyplants.core.Commons.PLANTS_TABLE_NAME

@Entity(tableName = PLANTS_TABLE_NAME)
data class PlantEntity(
    val plantName: String,
    val amountOfWater: Int,
    val description: String,
    val size: String,
    val time: Long,
    val nextWater: Long,
    val status: String,
    val imageUrl: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)
