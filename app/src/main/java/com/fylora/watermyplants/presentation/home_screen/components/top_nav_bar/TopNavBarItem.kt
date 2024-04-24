package com.fylora.watermyplants.presentation.home_screen.components.top_nav_bar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fylora.watermyplants.core.fontFamily
import com.fylora.watermyplants.presentation.ui.theme.PrimaryBlue
import com.fylora.watermyplants.presentation.ui.theme.TopNavBarItemColorUnselected

@Composable
fun TopNavBarItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        ),
        contentAlignment = Alignment.Center
    ) {
        if(isSelected) {
            Text(
                text = text,
                fontSize = 14.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = PrimaryBlue
            )
            Canvas(modifier = Modifier.matchParentSize()) {
                drawLine(
                    color = PrimaryBlue,
                    start = Offset(0f, size.height  - 4f),
                    end = Offset((size.width / 2f) + 4f, size.height - 4f),
                    strokeWidth = 2.dp.toPx(),
                    cap = StrokeCap.Round
                )
            }
        } else {
            Text(
                text = text,
                fontSize = 14.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                color = TopNavBarItemColorUnselected
            )
        }
    }
}

@Preview
@Composable
fun TopNavBarItemPreview() {
    TopNavBarItem(text = "Upcoming", isSelected = true) {}
}