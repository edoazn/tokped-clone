package com.example.tokped_clone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokped_clone.R
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme

@Composable
fun VerticalBanner(modifier: Modifier = Modifier) {
    val verticalBanner = listOf(
        R.drawable.banner_vertikal1,
        R.drawable.banner_vertikal2,
        R.drawable.banner_vertikal3,
        R.drawable.banner_vertikal4,
        R.drawable.banner_vertikal5,
    )

    LazyRow(
        modifier = modifier
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(verticalBanner) { banner ->
            Image(
                painter = painterResource(banner),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalBannerPrev() {
    Tokped_cloneTheme {
        VerticalBanner()
    }
}