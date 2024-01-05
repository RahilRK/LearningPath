package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.domain.model.DashboardOrders


@Preview(showSystemUi = false)
@Composable
fun DashboardOrdersListItem(
    model: DashboardOrders = DashboardOrders(icon = R.drawable.ic_direct_orders, orderType = "Direct Orders"),
//    onItemClick: (model: DashboardOrders) -> Unit = {}
) {

    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(4.dp).height(124.dp).width(124.dp),
        shape = RoundedCornerShape(16.dp),
    ) {

        Column(
            Modifier.padding(8.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painterResource(id = model.icon), contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
//                        onItemClick(Employee(resId = resID, name = name, designation = designation))
                    }
                    .padding(8.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.LightGray, CircleShape),
            )

            Text(
                text = model.orderType,
                fontSize = 16.sp,
                modifier = Modifier,
                textAlign = TextAlign.Center
            )

        }
    }
}

fun getOrdersList(): MutableList<DashboardOrders> {
    val list = mutableListOf<DashboardOrders>()
    list.add(DashboardOrders(orderType = "Direct Orders", icon = R.drawable.ic_direct_orders))
    list.add(DashboardOrders(orderType = "Special Orders", icon = R.drawable.ic_special_orders))
    list.add(DashboardOrders(orderType = "Offers", icon = R.drawable.ic_offers))
    list.add(DashboardOrders(orderType = "Contracts", icon = R.drawable.ic_contracts))
    list.add(DashboardOrders(orderType = "Driver", icon = R.drawable.ic_driver))
    list.add(DashboardOrders(orderType = "Trucks", icon = R.drawable.ic_trucks))

    return list
}