package com.example.tokped_clone.ui.model

import com.example.tokped_clone.R


data class ListCategoryMenu(
    val icon: Int,
    val title: String
)

val categoryList = listOf(
    ListCategoryMenu(R.drawable.cicil, "Cicil 0%"),
    ListCategoryMenu(R.drawable.cod, "Bayar COD"),
    ListCategoryMenu(R.drawable.computer, "Laptop Terbaru"),
    ListCategoryMenu(R.drawable.promo, "Discount"),
    ListCategoryMenu(R.drawable.official, "Official Store")
)
