package com.example.tokped_clone.ui.model

import com.example.tokped_clone.R

data class ProductDiscount(
    val imageRes: Int,
    val name: String,
    val price: String,
    val discount: String,
    val rating: Float,
    val location: String,
)

val dummyProductDiscount = listOf(
    ProductDiscount(
        imageRes = R.drawable.laptop1,
        name = "Laptop ASUS VivoBook 15 A516JA i3-1005G1",
        price = "Rp 5.999.000",
        discount = "20%",
        rating = 4.5f,
        location = "Jakarta",
    ),
    ProductDiscount(
        imageRes = R.drawable.laptop2,
        name = "HP Pavilion 14-dv1008TX i5-1135G7",
        price = "Rp 10.499.000",
        discount = "15%",
        rating = 4.7f,
        location = "Bandung",
    ),
    ProductDiscount(
        imageRes = R.drawable.laptop3,
        name = "Acer Aspire 5 A514-54G i5-1135G7",
        price = "Rp 8.299.000",
        discount = "10%",
        rating = 4.6f,
        location = "Surabaya",
    ),
)
