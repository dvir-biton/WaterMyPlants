package com.fylora.watermyplants.presentation.home_screen.components.plant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.watermyplants.core.fontFamily
import com.fylora.watermyplants.presentation.ui.theme.PlantSection

@Composable
fun DataTag(
    content: @Composable (modifier: Modifier) -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(PlantSection),
        contentAlignment = Alignment.Center
    ) {
        content(
            Modifier.padding(
                vertical = 2.dp,
                horizontal = 6.dp
            )
        )
    }
}

@Preview
@Composable
fun PreviewDataTag() {
    DataTag {
        Text(
            text = "Today",
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = fontFamily,
            color = Color.White,
            modifier = it
        )
    }
}