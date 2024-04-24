package com.fylora.watermyplants.data.mappers

import android.net.Uri
import com.fylora.watermyplants.data.entity.PlantEntity
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId

fun Plant.toEntity(): PlantEntity {
    return PlantEntity(
        plantName = name,
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

fun PlantEntity.toModel(): Plant {
    return Plant(
        name = plantName,
        amountOfWater = amountOfWater,
        description = description,
        size = PlantSize.fromType(size),
        time = LocalTime.ofSecondOfDay(time / 1000),
        nextWater = Instant.ofEpochMilli(nextWater).atZone(ZoneId.systemDefault()).toLocalDate(),
        status = PlantStatus.fromType(status),
        image = Uri.parse(imageUrl),
        id = id
    )
}
