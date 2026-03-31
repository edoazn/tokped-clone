package com.example.tokped_clone.ui.component.navigation

sealed class Screen(val route: String, val title: String) {
    object Login: Screen("login", "Login")
    object Home : Screen("home", "Home")
    object Feed : Screen("feed", "Feed")
    object OfficialStore : Screen("official_store", "Official Store")
    object Wishlist : Screen("wishlist", "Wishlist")
    object Transaction : Screen("transaction", "Transaction")

    companion object {
        val items = listOf(
            Login,
            Home,
            Feed,
            OfficialStore,
            Wishlist,
            Transaction
        )
    }
}
