package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.data.model.response.my_profile.RespMyProfile
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.LoadingDialog
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component.DashboardGridOrdersList
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component.Header

@Preview(showSystemUi = true)
@Composable
fun Dashboard() {

    val TAG = "Dashboard"

    val viewModel: DashboardViewModel = hiltViewModel()
//    val isLoadingState = viewModel.isLoadingState.collectAsState().value

    val myProfileState = viewModel.myProfileState.collectAsState().value
    var myProfileResponse = RespMyProfile()
    if(myProfileState.isLoading) {
        Log.d(TAG, "myProfileState: isLoading")
        LoadingDialog()
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
        LoadingDialog()
    }
    else if (unreadNotificationState.error.isNotEmpty()) {
        Log.e(TAG, "unreadNotificationState: error: ${unreadNotificationState.error}")
    } else {
        Log.d(TAG, "unreadNotificationState: success: ${unreadNotificationState.data}")
        unreadNotification = notificationCount
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.login_bg),
                    contentScale = ContentScale.Crop
                ),
        ) {
            Column(Modifier.padding(8.dp)) {

                myProfileResponse.user?.let {
                    Header(
                        user = it,
                        unreadNotification = unreadNotification
                    )
                }
                DashboardGridOrdersList()
            }
        }
    }
}