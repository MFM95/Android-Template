package com.template.supplier.base.uicomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding


@Composable
fun TopBar(
    title: String = "",
    icon: Int
) {
    Box(
        modifier = Modifier.statusBarsPadding(),
        contentAlignment = Alignment.BottomCenter
    ) {
        TopAppBar(
            title = { Text(text = title) },
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
            navigationIcon = { Image(painter = painterResource(id = icon), contentDescription = null)}
        )
        Box(
            modifier = Modifier
                .shadow(elevation = AppBarDefaults.TopAppBarElevation)
                .height(0.5.dp)
                .fillMaxWidth()
        )
    }
}
