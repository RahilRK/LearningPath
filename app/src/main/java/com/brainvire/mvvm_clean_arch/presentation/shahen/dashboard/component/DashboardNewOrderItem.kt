package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.common.toSafeInt
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.CurrentOrder
import com.brainvire.mvvm_clean_arch.domain.model.DashboardOrders
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.DashedDivider
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.from_to_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.more_screen_icon_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color_light


@Preview(showSystemUi = false)
@Composable
fun DashboardNewOrderListItem(
    model: CurrentOrder = CurrentOrder(id = 453434222, price = 2000, quantity = 3),
//    onItemClick: (model: DashboardOrders) -> Unit = {}
) {

    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "# ${model.id}",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    text = "${model.price} SAR/Each",
                    color = shahen_app_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 6.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = model.cityFromDetails?.name ?: "Jeddah",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.TopEnd),
                    text = model.cityFromDetails?.name ?: "Riyadh",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 6.dp)
                    .background(Color.White)
            ) {

                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "From",
                    color = from_to_color,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_radio), contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(12.dp)
                    )
                    DashedDivider(
                        color = shahen_app_color,
                        thickness = 1.dp,
                        modifier = Modifier
                            .width(250.dp)
                            .padding(0.dp)
                    )
                    Image(
                        painterResource(id = R.drawable.ic_radio), contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(12.dp)
                    )
                }

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    text = "To",
                    color = from_to_color,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 8.dp)
                    .background(Color.White)
            ) {

                Row(
                    modifier = Modifier.align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painterResource(id = R.drawable.ic_truck_blue), contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        modifier = Modifier.padding(start = 8.dp),
                        text = String.format(
                            "%s x %s %s",
                            model.truck?.name,
                            model.quantity.toSafeInt(),
                            "Truck"
                        ),
                        color = text_color_light,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

        }
    }
}