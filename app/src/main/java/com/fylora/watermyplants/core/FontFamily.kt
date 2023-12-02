package com.fylora.watermyplants.core

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.fylora.watermyplants.R

object Fonts {
    val fontFamily = FontFamily(
        Font(
            R.font.poppins_regular,
            FontWeight.Normal
        ),
        Font(
            R.font.poppins_light,
            FontWeight.Light
        ),
        Font(
            R.font.poppins_extrabold,
            FontWeight.ExtraBold
        ),
        Font(
            R.font.poppins_bold,
            FontWeight.Bold
        ),
        Font(
            R.font.poppins_black,
            FontWeight.Black
        ),
        Font(
            R.font.poppins_medium,
            FontWeight.Medium
        ),
        Font(
            R.font.poppins_semibold,
            FontWeight.SemiBold
        ),
        Font(
            R.font.poppins_thin,
            FontWeight.Thin
        ),
        Font(
            R.font.poppins_extralight,
            FontWeight.ExtraLight
        ),
        Font(
            R.font.poppins_italic,
            style = FontStyle.Italic
        ),
        Font(
            R.font.poppins_blackitalic,
            FontWeight.Black,
            style = FontStyle.Italic,
        )
    )
}

val fontFamily = Fonts.fontFamily