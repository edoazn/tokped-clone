package com.example.tokped_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tokped_clone.ui.component.BannerCategory
import com.example.tokped_clone.ui.component.BannerPromo
import com.example.tokped_clone.ui.component.CategoryItem
import com.example.tokped_clone.ui.component.DiscountSection
import com.example.tokped_clone.ui.component.MainTopBar
import com.example.tokped_clone.ui.component.TextCategory
import com.example.tokped_clone.ui.component.VerticalBanner
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tokped_cloneTheme {
                MarketApp()
            }
        }
    }
}

@Composable
fun MarketApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                    label = { Text("Feed") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Shopping") },
                    label = { Text("Keranjang") }
                )
                NavigationBarItem(
                    selected = true,
                    onClick = { /*TODO*/ },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Person") },
                    label = { Text("Akun") }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            MainTopBar()
            BannerCategory()
            CategoryItem()
            BannerPromo()
            TextCategory(title = "Khusus untuk Kamu~", subtitle = "Terbatas! Buruan Serbu")
            DiscountSection()
            TextCategory(title = "Pilihan Promo Hari ini")
            VerticalBanner()
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MarketAppPreview() {
    Tokped_cloneTheme {
        MarketApp()
    }
}