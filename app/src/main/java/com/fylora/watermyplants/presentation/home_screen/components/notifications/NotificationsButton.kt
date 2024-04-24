package com.fylora.watermyplants.presentation.home_screen.components.notifications

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fylora.watermyplants.R
import com.fylora.watermyplants.presentation.ui.theme.NotificationsButtonsColor
import com.fylora.watermyplants.presentation.ui.theme.NotificationsIconColor
import com.fylora.watermyplants.presentation.ui.theme.NotificationsIndicatorColor

@Composable
fun NotificationsButton(
    isHavingNotifications: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(
                color = NotificationsButtonsColor,
                shape = CircleShape
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {
        if(isHavingNotifications) {
            Canvas(
                modifier = Modifier
                    .matchParentSize()
                    .padding(
                        horizontal = 5.dp,
                        vertical = 2.dp
                    )
            ) {
                val radius = 3.dp.toPx()

                drawCircle(
                    color = NotificationsIndicatorColor,
                    radius = radius,
                    Offset(
                        x = size.width - radius,
                        y = radius
                    )
                )
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.notifications),
            tint = NotificationsIconColor,
            contentDescription = "Notifications",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun NotificationsButtonPreview() {
    NotificationsButton(isHavingNotifications = true) {
        
    }
}