package com.example.tokped_clone.ui.component.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean = false,
    val badgeCount: Int? = null
)
