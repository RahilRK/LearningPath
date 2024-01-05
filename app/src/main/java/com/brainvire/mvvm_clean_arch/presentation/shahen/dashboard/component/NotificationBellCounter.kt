package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.notification_counter_red_bg

@Preview(showSystemUi = true)
@Composable
fun NotificationBellCounter() {
    Box {

        Column(modifier = Modifier.align(Alignment.TopEnd).padding(bottom = 3.dp, end = 4.dp)) {
            NotificationCounter()
        }

        IconButton(modifier = Modifier.align(Alignment.TopEnd), onClick = {

        }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_notification),
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NotificationCounter(counter: String = "99") {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(16.dp)
            .background(notification_counter_red_bg)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = counter,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            fontSize = 10.sp
        )
    }
}