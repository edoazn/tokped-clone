package com.example.tokped_clone.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokped_clone.ui.component.BannerCategory
import com.example.tokped_clone.ui.component.BannerPromo
import com.example.tokped_clone.ui.component.CategoryItem
import com.example.tokped_clone.ui.component.DiscountSection
import com.example.tokped_clone.ui.component.MainTopBar
import com.example.tokped_clone.ui.component.TextCategory
import com.example.tokped_clone.ui.component.VerticalBanner
import com.example.tokped_clone.ui.model.ListCategoryMenu
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onCategoryClick: (String) -> Unit = {},
    onDiscountClick: (String) -> Unit = {},
    onVerticalBannerClick: (String) -> Unit = {},
) {
    val listState = rememberLazyListState()
    val pullToRefreshState = rememberPullToRefreshState()
    var isRefreshing by remember { mutableStateOf(false) }

    // Simulasi refresh
    val onRefresh: () -> Unit = {
        isRefreshing = true
    }
    // Simulasi selesai refresh setelah 2 detik
    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            delay(2000)
            isRefreshing = false
        }
    }

    PullToRefreshBox(
        modifier = modifier.fillMaxSize(),
        state = pullToRefreshState,
        isRefreshing = isRefreshing,
        onRefresh = onRefresh
    ) {
        LazyColumn(
            state = listState,
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            // Search bar
            item(key = "search_bar") {
                MainTopBar(
//                    onSearchClick = {},
//                    onQrClick = {},
//                    onMessageClick = {},
//                    onNotificationClick = {}
                )
            }

            // Banner kategori
            item(key = "banner_category") {
                BannerCategory()
            }

            // Category Grid
            item(key = "categories") {
                CategoryItem()
            }
            // Banner promo
            item(key = "banner_promo") {
                BannerPromo()
            }

            // Section khusus untuk kamu
            item(key = "text_khusus_kamu") {
                TextCategory(title = "Khusus untuk Kamu~", subtitle = "Terbatas! Buruan Serbu")
            }

            // Section diskon
            item(key = "discount_section") {
                DiscountSection()
            }

            // Section pilihan promo hari ini
            item(key = "text_pilihan_promo_hari_ini") {
                TextCategory(title = "Pilihan Promo Hari ini")
            }

            // Section banner vertikal
            item(key = "vertical_banner") {
                VerticalBanner()
            }
        }
    }

}