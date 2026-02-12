package com.example.tokped_clone.ui.component

import android.R.attr.content
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tokped_clone.R
import com.example.tokped_clone.ui.model.dummyListTopMenu

@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.background_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .height(120.dp)
        )

        // kode lama
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Search bar
//                OutlinedTextField(
//                    modifier = Modifier
//                        .widthIn(min = 220.dp),
//                    value = "",
//                    onValueChange = {},
//                    leadingIcon = {
//                        Icon(
//                            Icons.Default.Search,
//                            contentDescription = null,
//                        )
//                    },
//                    placeholder = { Text("Cari di Tokopedia", fontSize = 14.sp) },
//                )
                Box(
                    modifier = modifier
                        .widthIn(min = 220.dp)
                        .height(32.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    Row(
                        modifier = modifier
                            .padding(start = 8.dp)
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Icon(
                            Icons.Default.Search,
                            tint = Color.Black.copy(alpha = 0.7f),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = stringResource(R.string.txt_search_placeholder),
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                }
                // menu icon
                Icon(
                    Icons.Outlined.Email,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    Icons.Outlined.ShoppingCart,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)

                )
                Icon(
                    Icons.Outlined.Menu,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }

            Row(
                modifier = modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = null,
                    tint = Color(0xFF00AA5B),
                    modifier = Modifier.size(18.dp)
                )
                Text(stringResource(R.string.txt_dummy_addres), fontSize = 12.sp)
                Text(
                    stringResource(R.string.txt_dummy_username),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = null,
                    Modifier.size(18.dp)
                )
            }

            LazyRow(
                modifier = Modifier
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(dummyListTopMenu) { topMenu ->
                    TopMenu(listTopMenu = topMenu)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MainTopBarPreview() {
    MainTopBar()
//    MainTopMenu()
}
