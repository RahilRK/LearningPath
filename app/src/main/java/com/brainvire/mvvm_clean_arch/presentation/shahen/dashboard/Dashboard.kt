package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component.DashboardGridOrdersList
import com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component.Header

@Preview(showSystemUi = true)
@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.login_bg),
                contentScale = ContentScale.Crop
            ),
    ) {
        Column(Modifier.padding(8.dp)) {

            Header()
            DashboardGridOrdersList()
        }
    }
}