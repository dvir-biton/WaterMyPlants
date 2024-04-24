package com.fylora.watermyplants.presentation.home_screen.components.top_nav_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fylora.watermyplants.domain.util.SelectedSection

@Composable
fun TopNavBar(
    selectedSection: SelectedSection,
    onSelect: (section: SelectedSection) -> Unit
) {
    val items = listOf(
        SelectedSection.Upcoming,
        SelectedSection.ForgotToWater,
        SelectedSection.History
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(modifier = Modifier.width(2.dp))
        items.forEach { section ->
            TopNavBarItem(
                text = section.name,
                isSelected = section == selectedSection,
                onClick = {
                    onSelect(section)
                }
            )
            Spacer(modifier = Modifier.width(24.dp))
        }
    }
}

@Preview
@Composable
fun TopNavBarPreview() {
    TopNavBar(
        selectedSection = SelectedSection.Upcoming,
        onSelect = {

        }
    )
}