package com.example.tokped_clone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tokped_clone.R

@Composable
fun BannerPromo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.banner_promo1),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Image(
            painter = painterResource(R.drawable.banner_promo2),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Image(
            painter = painterResource(R.drawable.banner_promo3),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
    }
//
//    Spacer(modifier = Modifier.height(20.dp))
//
//    Image(
//        painter = painterResource(R.drawable.banner_event),
//        contentDescription = null,
//        modifier = Modifier
//            .fillMaxWidth()
//    )
}

@Preview(showBackground = true)
@Composable
private fun BannerPromoPreview() {
    BannerPromo()
}