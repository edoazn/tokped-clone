package com.example.tokped_clone.ui.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tokped_clone.ui.model.ProductDiscount
import com.example.tokped_clone.ui.model.dummyProductDiscount
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme

// CardPromo
@Composable
fun CardPromo(
    product: ProductDiscount,
    modifier: Modifier = Modifier
) {

    // Box dengan background
    Box(
        modifier = modifier

            .width(140.dp)
            .height(232.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White),
    ) {
        // Gambar barang
        Column(
            modifier = Modifier
                .padding(start = 7.dp, end = 7.dp)
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(121.dp),
            )

            // Text nama barang
            Text(
                text = product.name,
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                color = Color(0xFF2E3137),
                style = LocalTextStyle.current.copy(
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )
            // Text harga barang
            Text(
                text = product.price,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF485D56),
                style = LocalTextStyle.current.copy(
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )
            // Tag cashback
            Text(
                text = "${product.discount} Cashback",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF485D56),
                style = LocalTextStyle.current.copy(
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )
            /*
            Row dengan icon rating, jumlah terjual
             */
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Star,
                    tint = Color(0xFFFFC300),
                    contentDescription = null,
                    modifier = Modifier
                        .size(14.dp)
                )
                Text(
                    text = product.rating.toString() + " | Terjual 100+",
                    lineHeight = 10.sp,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF485D56),
                )
            }
            // Spacer
            Spacer(modifier = modifier.height(2.dp))

            /*
            Row dengan icon verified dan kota
             */
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    tint = Color(0xFF00A650),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = product.location,
                    lineHeight = 10.sp,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF485D56),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardDiscountPreview() {
    Tokped_cloneTheme {
        CardPromo(
            product = dummyProductDiscount.first()
        )
    }

}