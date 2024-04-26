package com.fylora.watermyplants.presentation.home_screen.components.plant

import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.fylora.watermyplants.core.fontFamily
import com.fylora.watermyplants.domain.model.Plant
import com.fylora.watermyplants.domain.util.PlantSize
import com.fylora.watermyplants.domain.util.PlantStatus
import com.fylora.watermyplants.presentation.ui.theme.OnBackgroundPrimaryBlack
import com.fylora.watermyplants.presentation.ui.theme.OnBackgroundSecondaryBlack
import com.fylora.watermyplants.presentation.ui.theme.StrokeColor
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun PlantCard(
    plant: Plant,
    onButtonClick: () -> Unit,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(167.dp)
            .height(256.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(
                width = 1.dp,
                color = StrokeColor,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .zIndex(1f)
        ) {
            DataTag {
                Text(
                    text = "${plant.amountOfWater}ml",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = fontFamily,
                    color = Color.White,
                    modifier = it
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            DataTag {
                Text(
                    text = plant.nextWater.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = fontFamily,
                    color = Color.White,
                    modifier = it,
                )
            }
        }
        Column {
           AsyncImage(
               model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEiwJli8imdv3w_5ubaH54UgeD7_T5tprVkA&usqp=CAU",
               contentDescription = plant.name,
               modifier = Modifier.weight(0.8f),
               contentScale = ContentScale.Crop
           )
           Row(
               modifier =  Modifier.padding(12.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Column(modifier = Modifier.weight(1f)) {
                   Text(
                       text = plant.name,
                       fontSize = 14.sp,
                       fontFamily = fontFamily,
                       fontWeight = FontWeight.SemiBold,
                       color = OnBackgroundPrimaryBlack,
                       overflow = TextOverflow.Ellipsis,
                       maxLines = 1
                   )
                   Text(
                       text = plant.description,
                       fontSize = 12.sp,
                       fontFamily = fontFamily,
                       color = OnBackgroundSecondaryBlack,
                       overflow = TextOverflow.Ellipsis,
                       maxLines = 1
                   )
               }
               Spacer(modifier = Modifier.width(8.dp))
               WaterButton(
                   isChecked = plant.status == PlantStatus.Watered,
                   onClick = onButtonClick
               )
           }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlantCard() {
    PlantCard(
        plant = Plant(
            name = "Bidbid",
            amountOfWater = 10,
            description = "This is the plant that will be created",
            size = PlantSize.Medium,
            time = LocalTime.now(),
            nextWater = LocalDate.now(),
            status = PlantStatus.Upcoming,
            image = Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEiwJli8imdv3w_5ubaH54UgeD7_T5tprVkA&usqp=CAU"),
            id = null
        ), {}, {}
    )
}