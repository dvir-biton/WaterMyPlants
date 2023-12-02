package com.fylora.watermyplants.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.fylora.watermyplants.data.entity.PlantEntity
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import java.net.URI
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
fun Plant.toEntity(): PlantEntity {
    return PlantEntity(
        plantName = plantName,
        amountOfWater = amountOfWater,
        description = description,
        size = size.type,
        time = time.toSecondOfDay() * 1000L,
        nextWater = nextWater.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000L,
        status = status.type,
        imageUrl = image.toString(),
        id = id
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun PlantEntity.toModel(): Plant {
    return Plant(
        plantName = plantName,
        amountOfWater = amountOfWater,
        description = description,
        size = PlantSize.fromType(size),
        time = LocalTime.ofSecondOfDay(time / 1000),
        nextWater = Instant.ofEpochMilli(nextWater).atZone(ZoneId.systemDefault()).toLocalDate(),
        status = PlantStatus.fromType(status),
        image = URI.create(imageUrl),
        id = id
    )
}
