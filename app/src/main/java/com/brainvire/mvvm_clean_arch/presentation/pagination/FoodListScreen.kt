package com.brainvire.mvvm_clean_arch.presentation.pagination

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork
import com.brainvire.mvvm_clean_arch.presentation.pagination.component.FoodList
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.TopBar

@Preview
@Composable
fun FoodListScreen(
    viewModel: PaginationViewModel = hiltViewModel(),
) {

    val TAG = "FoodListScreen"

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            TopBar(
                showTitle = true,
                title = "Food List"
            )

            Column(Modifier.padding(8.dp)) {
                FoodList(viewModel = viewModel)
            }
        }
    }
}