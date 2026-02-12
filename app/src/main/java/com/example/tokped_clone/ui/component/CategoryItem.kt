package com.example.tokped_clone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tokped_clone.ui.model.ListCategoryMenu
import com.example.tokped_clone.ui.model.categoryList
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme


@Composable
fun CategoryItem(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.padding(16.dp),
//        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categoryList) { category ->
            CategoryItemCard(listCategoryMenu = category)
        }
    }
}

@Composable
fun CategoryItemCard(
    listCategoryMenu: ListCategoryMenu,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 8.dp),
    ) {
        Image(
            painter = painterResource(listCategoryMenu.icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = listCategoryMenu.title,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            lineHeight = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryItemPreview() {
    Tokped_cloneTheme {
        CategoryItem()
    }
}