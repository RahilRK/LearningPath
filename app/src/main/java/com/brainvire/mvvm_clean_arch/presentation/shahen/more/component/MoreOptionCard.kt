package com.brainvire.mvvm_clean_arch.presentation.shahen.more.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.divide_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.more_screen_icon_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.text_color

@Preview
@Composable
fun MoreOptionCard(modifier: Modifier = Modifier, logoutClick: () -> Unit = {}) {

    Card(modifier = modifier, elevation = 8.dp, shape = RoundedCornerShape(12.dp)) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "Contact Us",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                )


                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(more_screen_icon_color)
                    )
                }
            }

            Divider(
                modifier = Modifier.padding(start = 16.dp),
                color = divide_color,
                thickness = 1.dp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "Terms & Condition",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )


                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(more_screen_icon_color)
                    )
                }
            }

            Divider(
                modifier = Modifier.padding(start = 16.dp),
                color = divide_color,
                thickness = 1.dp
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {

                Text(
                    text = "Privacy Policy",
                    color = text_color,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )


                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                ) {
                    Image(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Filled.ArrowForwardIos,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(more_screen_icon_color)
                    )
                }
            }

            Divider(
                modifier = Modifier.padding(start = 16.dp),
                color = divide_color,
                thickness = 1.dp
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White)
            ) {


                Row(modifier = Modifier.clickable {
                    logoutClick()
                }) {
                    Text(
                        text = "Logout",
                        color = Color.Red,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Image(
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 4.dp),
                        imageVector = Icons.Filled.Logout,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(Color.Red)
                    )
                }
            }
        }
    }
}