package com.example.tokped_clone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokped_clone.R
import kotlinx.coroutines.delay

@Composable
fun BannerCategory(
    modifier: Modifier = Modifier
) {
    val banners = listOf(
        R.drawable.banner1,
        R.drawable.banner2,
        R.drawable.banner3,
    )
    val pagerState = rememberPagerState { banners.size }

    // Auto scroll
    LaunchedEffect(pagerState) {
        while (true){
            delay(3000L)
            val nextPage = (pagerState.currentPage + 1) % banners.size
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.wrapContentHeight()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) { page ->
                Image(
                    painter = painterResource(banners[page]),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            // Page Indicator
            Row(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(banners.size) { index ->
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(
                                if (pagerState.currentPage == index) Color.White
                                else Color.White.copy(alpha = 0.5f)
                            )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BannerCategoryPreview() {
    BannerCategory()
}