package com.example.tokped_clone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tokped_clone.R

// Set of Material typography styles to start with
val MyCustomFont = FontFamily(
    Font(R.font.poppinsregular, FontWeight.Normal),
    Font(R.font.poppinssemibold, FontWeight.Medium),
    Font(R.font.poppinssemibold, FontWeight.Bold)
)

// Custom font
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MyCustomFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontFamily = MyCustomFont,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    ),
    titleLarge = TextStyle(
        fontFamily = MyCustomFont,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
)