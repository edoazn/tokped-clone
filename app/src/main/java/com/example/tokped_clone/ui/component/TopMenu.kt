package com.example.tokped_clone.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tokped_clone.ui.model.ListTopMenu
import com.example.tokped_clone.ui.model.dummyListTopMenu
import com.example.tokped_clone.ui.theme.Tokped_cloneTheme

@Composable
fun TopMenu(
    listTopMenu: ListTopMenu,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Menu Icon
        Image(
            painter = painterResource(listTopMenu.imageTopBar),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        // Column
        Column {
            // Header Text
            Text(
                text = listTopMenu.txtHeader,
                fontSize = 14.sp,
            )
            // Body Text
            Text(
                text = listTopMenu.txtBody,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Divider
        VerticalDivider()
    }
}

@Preview(showBackground = true)
@Composable
private fun TopMenuPreview() {
    Tokped_cloneTheme {
        TopMenu(
            listTopMenu = dummyListTopMenu[0]
        )
    }
}