package com.example.tokped_clone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokped_clone.R
import com.example.tokped_clone.ui.model.dummyProductDiscount
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme

@Composable
fun DiscountSection(modifier: Modifier = Modifier) {
    // Box dengan background
    Box(
        modifier = modifier
            .fillMaxWidth()
            .size(256.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF692202),
                        Color(0xFF9F2F01)
                    )
                )
            ),
    ) {
        // Image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.banner_diskon),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),
                alignment = Alignment.Center,
            )

            // LazyRow
            LazyRow(
                modifier = modifier
                    .padding(end = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(dummyProductDiscount) { product ->
                    CardPromo(product = product)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DiscountSectionPreview() {
    Tokped_cloneTheme {
        DiscountSection()
    }
}