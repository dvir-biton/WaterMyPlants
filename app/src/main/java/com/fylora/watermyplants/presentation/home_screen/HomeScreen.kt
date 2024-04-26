package com.fylora.watermyplants.presentation.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fylora.watermyplants.core.Route
import com.fylora.watermyplants.core.fontFamily
import com.fylora.watermyplants.presentation.home_screen.components.no_plants_message.NoPlantsMessage
import com.fylora.watermyplants.presentation.home_screen.components.notifications.NotificationsButton
import com.fylora.watermyplants.presentation.home_screen.components.plant.PlantCard
import com.fylora.watermyplants.presentation.home_screen.components.top_nav_bar.TopNavBar
import com.fylora.watermyplants.presentation.util.UiEvent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .background(Color.Transparent),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "My Plants!",
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 32.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                // TODO: notifications
                NotificationsButton(
                    isHavingNotifications = true,
                    onClick = {
                        viewModel.onEvent(
                            HomeEvents.NavigateToNotifications
                        )
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add plant"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it),
        ) {
            TopNavBar(
                onSelect = { section ->
                    viewModel.onEvent(
                        HomeEvents.OnSectionChange(
                            section = section
                        )
                    )
                },
                selectedSection = viewModel.state.value.selectedSection
            )
            Spacer(modifier = Modifier.height(20.dp))
            val plantsToShow = viewModel.state.value.plants.filter { plant ->
                plant.status == viewModel.state.value.selectedSection.status
            }
            if (plantsToShow.isEmpty()) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    NoPlantsMessage()
                }
                // To take the space if the bottom bar in the scaffold and make it appear centered
                Column(modifier = Modifier.weight(0.2f)) { }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier.weight(1f),
                    columns = GridCells.Adaptive(167.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(
                        items = plantsToShow
                    ) { plant ->
                        PlantCard(
                            plant = plant,
                            onButtonClick = {
                                viewModel.onEvent(
                                    HomeEvents.UpdatePlantStatus(plant)
                                )
                            },
                            onClick = {
                                UiEvent.Navigate(
                                    Route.PLANT_DETAILS_SCREEN + "/${plant.id}"
                                )
                            }, // TODO: plant screen
                        )
                    }
                }
            }
        }
    }
}