package com.brainvire.mvvm_clean_arch.presentation.shahen.dashboard.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.brainvire.mvvm_clean_arch.data.model.response.dashboard.CurrentOrder

@Composable
fun DashboardNewOrderList(
    list: MutableList<CurrentOrder> = arrayListOf(),
) {

    val mealLazyListState: LazyListState = rememberLazyListState()

    LazyColumn(content = {
        itemsIndexed(list) { index, model ->

            DashboardNewOrderListItem(
                model
            )
        }
    }, modifier = Modifier, state = mealLazyListState)

}