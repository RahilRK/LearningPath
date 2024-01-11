package com.brainvire.mvvm_clean_arch.presentation.shahen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color

@Preview
@Composable
fun TopBar(
    onBackPress: () -> Unit = {},
    showBackArrow: Boolean = false,
    navigationIcon: ImageVector = Icons.Outlined.LocationOn,
    showTitle: Boolean = false,
    title: String = "Title",
    showFilter: Boolean = false,
) {
    TopAppBar(title = {
        Box(modifier = Modifier.fillMaxWidth()) {

            if (showBackArrow) {
                Image(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp)
                        .clickable {
                            onBackPress()
                        },
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

            if (showTitle) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(12.dp),
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            if (showFilter) {
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp),
                    imageVector = Icons.Filled.FilterAlt,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }
    }, backgroundColor = shahen_app_color, elevation = 4.dp)
}