package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color_light

@Preview
@Composable
fun DashboardOrderCount(orderType: String = "New", count: Int = 3) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {

        if(count > 0){
            if(orderType == "New") {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = "New Orders ($count)",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            else {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = "Current Orders ($count)",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        else {
            if(orderType == "New") {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = "New Order",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            else {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = "Current Order",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Text(
            modifier = Modifier
                .align(Alignment.CenterEnd),
            text = "View All",
            color = text_color_light,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal
        )
    }
}