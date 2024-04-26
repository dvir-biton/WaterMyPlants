package com.fylora.watermyplants.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.fylora.watermyplants.R
import com.fylora.watermyplants.presentation.home_screen.HomeScreen
import com.fylora.watermyplants.presentation.ui.theme.WaterMyPlantsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterMyPlantsTheme {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val painter = painterResource(R.drawable.background_illustration)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .aspectRatio(painter.intrinsicSize.width / painter.intrinsicSize.height)
                            .fillMaxWidth()
                    )
                    HomeScreen()
                }
            }
        }
    }
}
