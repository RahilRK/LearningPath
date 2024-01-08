package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard

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
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.LoadingDialog
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component.DashboardGridOrdersList
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component.Header

@Preview(showSystemUi = true)
@Composable
fun Dashboard() {

    val viewModel: DashboardViewModel = hiltViewModel()
    val isLoadingState = viewModel.isLoadingState.collectAsState().value

    Box {
        if (isLoadingState) {
            LoadingDialog()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.login_bg),
                    contentScale = ContentScale.Crop
                ),
        ) {
            Column(Modifier.padding(8.dp)) {

                Header(
//                viewModel
                )
                DashboardGridOrdersList()
            }
        }
    }
}