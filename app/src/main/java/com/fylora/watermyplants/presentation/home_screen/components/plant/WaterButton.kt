package com.fylora.watermyplants.presentation.home_screen.components.plant

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fylora.watermyplants.R
import com.fylora.watermyplants.presentation.ui.theme.NeedToWater
import com.fylora.watermyplants.presentation.ui.theme.Watered

@Composable
fun WaterButton(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onClick: () -> Unit
) {
    val icon = if(isChecked) painterResource(id = R.drawable.watered)
        else painterResource(id = R.drawable.need_to_water)
    val backgroundColor = if(isChecked) Watered
        else NeedToWater

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = icon,
            contentDescription = "Mark as watered",
            tint = Color.White,
            modifier = Modifier.padding(4.dp)
        )
    }
}