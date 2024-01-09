package com.brainvire.mvvm_clean_arch.presentation.shahen.more.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.more_screen_icon_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color

@Preview
@Composable
fun MoreCard(title: String = "Title", showChangeLanguageBtn: Boolean = false) {

    Card(elevation = 8.dp, shape = RoundedCornerShape(12.dp), modifier = Modifier.height(52.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White)
        ) {

            Text(
                text = title,
                color = text_color,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )


            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                if(showChangeLanguageBtn) {
                    Text(
                        modifier = Modifier.padding(end = 16.dp),
                        text = "English",
                        color = shahen_app_color,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Image(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(more_screen_icon_color)
                )
            }
        }
    }
}