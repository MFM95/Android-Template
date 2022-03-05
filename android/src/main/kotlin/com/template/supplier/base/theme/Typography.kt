package com.template.supplier.base.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.template.supplier.R

private val mainFont = FontFamily(
    Font(R.font.taager_light, FontWeight.Light),
    Font(R.font.taager_regular, FontWeight.Normal),
    Font(R.font.taager_medium, FontWeight.Medium),
    Font(R.font.taager_bold, FontWeight.Bold),
    Font(R.font.taager_extrabold, FontWeight.ExtraBold),
)

val Typography = Typography(
    defaultFontFamily = mainFont,
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    )
)