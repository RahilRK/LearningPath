package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brainvire.learning.R

@Preview(showSystemUi = true)
@Composable
fun Header(
    context: Context = LocalContext.current,
    onSearchClick: () -> Unit = {}
) {
    Column {
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.align(Alignment.CenterStart)) {
                Image(
                    painterResource(id = R.drawable.ic_person_img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically)
                        .border(1.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .padding(start = 12.dp)
                ) {
                    Text(
                        text = "Welcome",
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        text = "Jackson Day",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }

            Box(modifier = Modifier.align(Alignment.CenterEnd)) {

                NotificationBellCounter()
            }

        }
    }
}
