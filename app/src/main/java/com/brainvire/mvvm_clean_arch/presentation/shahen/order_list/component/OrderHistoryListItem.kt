package com.brainvire.mvvm_clean_arch.presentation.shahen.order_list.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.common.toSafeInt
import com.brainvire.mvvm_clean_arch.data.model.response.order_history.RespOrderHistoryList
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.DashedDivider
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.brown
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.from_to_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color_light
import com.brainvire.mvvm_clean_arch.util.Constants
import com.brainvire.mvvm_clean_arch.util.DateUtils


@Preview(showSystemUi = false)
@Composable
fun OrderHistoryListItem(
    model: RespOrderHistoryList.Data = RespOrderHistoryList.Data(
        id = 453434222,
        section = "order",
        price = 2000,
        quantity = 3,
        weight = "5",
        createdAt = "23 May 2023",
        offloadingDate = "29 May 2023",
    ),
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

            when (model.section) {
                Constants.SECTION_DIRECT_ORDER -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        text = "Direct Orders",
                        color = brown,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Constants.SECTION_CONTRACT -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        text = "Contracts",
                        color = brown,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Constants.SECTION_SPECIAL_ORDER -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        text = "Special Orders",
                        color = brown,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 2.dp)
                    .background(Color.White)
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = "# ${model.id}",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    text = "${model.price} SAR/Each",
                    color = shahen_app_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .background(Color.White)
            ) {

                Row(
                    modifier = Modifier
                        .weight(0.6f)
                ) {
                    Column(modifier = Modifier.padding(end = 24.dp)) {
                        Text(
                            text = "Weight",
                            color = text_color_light,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )

                        Text(
                            text = "${model.weight} Tons",
                            color = text_color,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Column(modifier = Modifier) {
                        Text(
                            text = "Commodities",
                            color = text_color_light,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )

                        Text(
                            text = model.goodsType?.name ?: "Liquid",
                            color = text_color,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxWidth(), horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Requester",
                        color = text_color_light,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                    )

                    Text(
                        text = model.requester?.name ?: "XYZ",
                        color = text_color,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    /*
                                        when (model.section) {
                                            Constants.SECTION_DIRECT_ORDER -> {
                                                Text(
                                                    text = "Direct Orders",
                                                    color = brown,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            }

                                            Constants.SECTION_CONTRACT -> {
                                                Text(
                                                    text = "Contracts",
                                                    color = text_color,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            }

                                            Constants.SECTION_SPECIAL_ORDER -> {
                                                Text(
                                                    text = "Special Orders",
                                                    color = brown,
                                                    fontSize = 12.sp,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            }
                                        }
                    */
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                    .background(Color.White)
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = DateUtils.toConvertDateFormat(model.createdAt.orEmpty()),
                    color = text_color_light,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    text = DateUtils.toConvertDateFormat(model.offloadingDate.orEmpty()),
                    color = text_color_light,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp)
                    .background(Color.White)
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart),
                    text = model.cityFromDetails?.name ?: "Jeddah",
                    color = text_color,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    text = model.cityFromDetails?.name ?: "Riyadh",
                    color = text_color,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp)
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