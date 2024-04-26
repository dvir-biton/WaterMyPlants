package com.fylora.watermyplants.presentation.home_screen.components.no_plants_message

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fylora.watermyplants.R
import com.fylora.watermyplants.core.fontFamily
import com.fylora.watermyplants.presentation.ui.theme.OnBackgroundPrimaryBlack

@Composable
fun NoPlantsMessage(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.empty_plants),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Sorry, no plants were found.\nPlease add a new plant to show here.",
                color = OnBackgroundPrimaryBlack,
                textAlign = TextAlign.Center,
                fontFamily = fontFamily
            )
        }

        ActionButton(text = "Add A New Plant", {})
    }
}