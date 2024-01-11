package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DashboardGridOrdersList() {

    val context = LocalContext.current
    val list = getOrdersList()
    val mealLazyListState: LazyGridState = rememberLazyGridState()

    LazyVerticalGrid(
        modifier = Modifier
            .padding(top = 12.dp),
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = mealLazyListState
    ) {
        itemsIndexed(list) { index, model ->

            DashboardOrdersListItem(
                model = model,
            )
        }
    }

}