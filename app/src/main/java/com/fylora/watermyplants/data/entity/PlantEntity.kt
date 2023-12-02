package com.fylora.watermyplants.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URI

@Entity(tableName = "plants")
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
