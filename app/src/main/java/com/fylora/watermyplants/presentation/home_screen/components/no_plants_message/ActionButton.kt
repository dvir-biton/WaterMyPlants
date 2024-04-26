package com.fylora.watermyplants.presentation.home_screen.components.no_plants_message

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fylora.watermyplants.core.fontFamily
import com.fylora.watermyplants.presentation.ui.theme.PrimaryBlue

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    width: Dp = 262.dp,
    height: Dp = 48.dp,
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(width)
            .height(height)
            .background(PrimaryBlue)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
    }
}