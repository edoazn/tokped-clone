package com.example.tokped_clone.ui.component.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainBottomBar(
    items: List<BottomNavItem>,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(NavConstants.BottomNavHeight)
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ),
        color = NavConstants.NavBackground,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items.forEachIndexed { index, item ->
                NavItem(
                    item = item,
                    isSelected = selectedItem == index,
                    onClick = { onItemSelected(index) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun NavItem(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) NavConstants.SelectedIconScale else 1f,
        animationSpec = tween(NavConstants.ANIMATION_DURATION),
        label = "scale"
    )

    val iconColor by animateColorAsState(
        targetValue = if (isSelected) NavConstants.SelectedColor else NavConstants.UnselectedColor,
        animationSpec = tween(NavConstants.ANIMATION_DURATION),
        label = "color"
    )

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null, // Hilangkan ripple default untuk custom effect
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
//        // Background indicator (hanya muncul saat selected)
//        AnimatedVisibility(
//            visible = isSelected,
//            enter = fadeIn() + scaleIn(initialScale = 0.5f),
//            exit = fadeOut() + scaleOut(targetScale = 0.5f)
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(48.dp)
//            )
//        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Icon dengan animasi scale
            Box(
                modifier = Modifier.scale(scale),
                contentAlignment = Alignment.Center
            ) {
                BadgedBox(
                    badge = {
                        if (item.badgeCount != null) {
                            Badge { Text(item.badgeCount.toString()) }
                        } else if (item.hasNews) {
                            Badge()
                        }
                    }
                ) {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unSelectedIcon,
                        contentDescription = item.title,
                        tint = iconColor,
                        modifier = Modifier.size(NavConstants.IconSize)
                    )
                }
            }

            // Label dengan animasi
            AnimatedVisibility(
                visible = isSelected,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Text(
                    text = item.title,
                    color = NavConstants.SelectedColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // Efek ripple custom (lingkaran)
        if (isSelected) {
            LaunchedEffect(Unit) {
                // Trigger haptic feedback ringan
                // val haptic = LocalHapticFeedback.current
                // haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        }
    }
}