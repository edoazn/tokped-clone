package com.example.tokped_clone.ui.model

import com.example.tokped_clone.R

data class ListTopMenu(
    val imageTopBar: Int,
    val txtHeader: String,
    val txtBody: String,
)

val dummyListTopMenu = listOf(
    ListTopMenu(
        imageTopBar = R.drawable.gopay,
        txtHeader = "GoPay",
        txtBody = "Rp. 15.000",
    ),
    ListTopMenu(
        imageTopBar = R.drawable.plus,
        txtHeader = "Diskon 70%",
        txtBody = "Langganan, yuk!",
    ),
    ListTopMenu(
        imageTopBar = R.drawable.rewards,
        txtHeader = "Silver",
        txtBody = "100 Poin",
    )
)