package com.example.tokped_clone.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tokped_clone.ui.component.navigation.BottomNavItem
import com.example.tokped_clone.ui.component.navigation.MainBottomBar
import com.example.tokped_clone.ui.component.navigation.Screen
import com.example.tokped_clone.ui.screens.feed.FeedScreen
import com.example.tokped_clone.ui.screens.home.HomeScreen
import com.example.tokped_clone.ui.screens.login.LoginScreen
import com.example.tokped_clone.ui.screens.official.OfficialStore
import com.example.tokped_clone.ui.screens.wishlist.WishListScreen
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
    val navController = rememberNavController()

    val navItems = listOf(
        BottomNavItem(
            route = Screen.Home.route,
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
        ),
        BottomNavItem(
            route = Screen.Feed.route,
            title = "Feed",
            selectedIcon = Icons.Filled.AddCircle,
            unSelectedIcon = Icons.Outlined.AddCircle,
        ),
        BottomNavItem(
            route = Screen.OfficialStore.route,
            title = "Official Store",
            selectedIcon = Icons.Filled.ShoppingCart,
            unSelectedIcon = Icons.Outlined.ShoppingCart,
            hasNews = true
        ),
        BottomNavItem(
            route = Screen.Wishlist.route,
            title = "Wishlist",
            selectedIcon = Icons.Filled.Favorite,
            unSelectedIcon = Icons.Outlined.Favorite,
            badgeCount = 5
        ),
    )

    // Deteksi halaman saat ini
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Halaman yang boleh menampilkan bottom bar
    val bottomBarVisibleRoutes = listOf(
        Screen.Home.route,
        Screen.Feed.route,
        Screen.OfficialStore.route,
        Screen.Wishlist.route
    )
    val isBottomBarVisible = currentDestination?.route in bottomBarVisibleRoutes

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.navigationBars),
        bottomBar = {
            if (isBottomBarVisible) {
                val selectedIndex = navItems.indexOfFirst { navItem ->
                    currentDestination?.hierarchy?.any { destination ->
                        destination.route == navItem.route
                    } == true
                }.coerceAtLeast(0)


                MainBottomBar(
                    items = navItems,
                    selectedItem = selectedIndex,
                    onItemSelected = { index ->
                        val item = navItems[index]
                        navController.navigate(item.route) {
                            // Pop up to the start destination of the graph to avoid building up a large stack of destinations
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Login.route) { LoginScreen() }
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Feed.route) { FeedScreen() }
            composable(Screen.OfficialStore.route) { OfficialStore() }
            composable(Screen.Wishlist.route) { WishListScreen() }
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