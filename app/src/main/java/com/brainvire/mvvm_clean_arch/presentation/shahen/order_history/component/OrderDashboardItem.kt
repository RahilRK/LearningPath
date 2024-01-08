package com.brainvire.mvvm_clean_arch.presentation.shahen.order_history.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.mvvm_clean_arch.data.model.response.direct_order.dashboard.Data
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color


@Preview(showSystemUi = false)
@Composable
fun OrderDashboardItem(
    model: Data = Data(count = 12, label = "New"),
//    onItemClick: (model: DashboardOrders) -> Unit = {}
) {

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .height(106.dp)
            .width(164.dp),
        shape = RoundedCornerShape(16.dp),
    ) {

        Column(
            Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = model.label ?: "12",
                fontSize = 14.sp,
                modifier = Modifier,
                textAlign = TextAlign.Center,
                color = text_color,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = model.count.toString(),
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center,
                color = shahen_app_color,
                fontWeight = FontWeight.SemiBold
            )

        }
    }
}