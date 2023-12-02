package com.fylora.watermyplants.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.fylora.watermyplants.data.entity.PlantNotificationEntity
import com.fylora.watermyplants.domain.model.PlantNotification
import java.time.Instant
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
fun PlantNotification.toEntity(): PlantNotificationEntity {
    return PlantNotificationEntity(
        body = body,
        action = action,
        plantId = plantId,
        timestamp = timestamp.atZone(ZoneId.systemDefault()).toEpochSecond() * 1000L,
        isOpened = isOpened,
        id = id
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun PlantNotificationEntity.toModel(): PlantNotification {
    return PlantNotification(
        body = body,
        action = action,
        plantId = plantId,
        timestamp = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime(),
        isOpened = isOpened,
        id = id
    )
}
