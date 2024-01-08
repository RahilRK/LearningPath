package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import android.content.Context
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.DashboardViewModel

@Preview(showSystemUi = true)
@Composable
fun Header(
    viewModel: DashboardViewModel = hiltViewModel(),
    context: Context = LocalContext.current,
    profileImageOnClick: () -> Unit = {}
) {
    val TAG = "Header"

    val myProfileState = viewModel.myProfileState.collectAsState().value
    var myProfileResponse = RespMyProfile()
    if(myProfileState.isLoading) {
        Log.d(TAG, "myProfileState: isLoading")
    }
    else if (myProfileState.error.isNotEmpty()) {
        Log.e(TAG, "myProfileState: error: ${myProfileState.error}")
    } else {
        Log.d(TAG, "myProfileState: success: ${myProfileState.data}")
        myProfileState.data?.data?.let {
            myProfileResponse = it
        }
    }

    val unreadNotificationState = viewModel.unreadNotificationState.collectAsState().value
    val notificationCount = viewModel.notificationCount.collectAsState().value
    var unreadNotification = 0.0

    if(unreadNotificationState.isLoading) {
        Log.d(TAG, "unreadNotificationState: isLoading")
    }
    else if (unreadNotificationState.error.isNotEmpty()) {
        Log.e(TAG, "unreadNotificationState: error: ${unreadNotificationState.error}")
    } else {
        Log.d(TAG, "unreadNotificationState: success: ${unreadNotificationState.data}")
        unreadNotification = notificationCount
    }

    Column {
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.align(Alignment.CenterStart)) {
                AsyncImage(
                    model = myProfileResponse.user?.serviceProvider?.logoUrl,
                    contentDescription = "Dashboard user profile image",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterVertically)
                        .border(1.dp, Color.White, CircleShape),
                    contentScale = ContentScale.Crop,
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
//                        text = "Abc",
                        text = "${myProfileResponse.user?.name}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }

            Box(modifier = Modifier.align(Alignment.CenterEnd)) {

                NotificationBellCounter(unreadNotification = unreadNotification)
            }

        }
    }
}
