package com.fylora.watermyplants

import android.net.Uri
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import java.time.LocalDate
import java.time.LocalTime

fun plant(): Plant = Plant(
    name = "Bidbid",
    amountOfWater = 10,
    description = "This is the plant that will be created",
    size = PlantSize.Medium,
    time = LocalTime.now(),
    nextWater = LocalDate.now(),
    status = PlantStatus.Watered,
    image = Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEiwJli8imdv3w_5ubaH54UgeD7_T5tprVkA&usqp=CAU"),
    id = null
)