package com.example.e_commerce.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.e_commerce.R

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontSize = 24.sp,
        color = White
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 18.sp,
        color = White
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 14.sp,
        color = DarkBlue,
    ),
    bodyMedium = TextStyle(

        fontSize = 16.sp,
        color = White
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        color = DarkBlue,
        fontSize = 18.sp
    ),
    labelLarge = TextStyle(
        fontSize = 20.sp,
        color = White,
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontSize = 18.sp,
        color = White
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)