package com.brainvire.mvvm_clean_arch.presentation.pagination.component

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.presentation.pagination.PaginationViewModel
import com.brainvire.mvvm_clean_arch.presentation.pagination.state.FoodListState
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.LoadingDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FoodList(
    viewModel: PaginationViewModel = hiltViewModel(),
) {

    val TAG = "FoodList"

    val context = LocalContext.current
    var offset = 0
    val scrollState = rememberLazyListState()
    val offsetState = viewModel.offset.collectAsState().value
    val isLoadingState = viewModel.isLoading.collectAsState().value
    val coroutineScope: CoroutineScope = rememberCoroutineScope()

    /*
        val isAtBottom by remember {
            derivedStateOf {
                val layoutInfo = scrollState.layoutInfo
                val visibleItemsInfo = layoutInfo.visibleItemsInfo
                if (layoutInfo.totalItemsCount == 0) {
                    false
                } else {
                    val lastVisibleItem = visibleItemsInfo.last()
                    val viewportHeight = layoutInfo.viewportEndOffset + layoutInfo.viewportStartOffset

                    (lastVisibleItem.index + 1 == layoutInfo.totalItemsCount &&
                            lastVisibleItem.offset + lastVisibleItem.size <= viewportHeight)

                    Log.d(TAG, "FoodList: lastVisibleItem: ${lastVisibleItem.index}")
                }
            }
        }
    */


    val foodListState =
        viewModel.getFoodListState.collectAsState(initial = FoodListState.Loading)
    when (val result = foodListState.value) {
        FoodListState.Loading -> {
            Log.d(TAG, "FoodListState: Loading")
            LoadingDialog()
        }

        is FoodListState.Success -> {

            val nestedScrollConnection = remember {
                object : NestedScrollConnection {

                    override fun onPostScroll(
                        consumed: Offset,
                        available: Offset,
                        source: NestedScrollSource
                    ): Offset {

                        val lastVisibleItem = scrollState.layoutInfo.visibleItemsInfo.last().index
//                        Log.d(TAG, "FoodList: lastVisibleItem: $lastVisibleItem")
                        Log.d(TAG, "FoodList: offsetState: $offset")

                        if (lastVisibleItem == offsetState -1 && !isLoadingState) {

                            viewModel.setPageNumber(value = 1)
                            viewModel.getFoodList()
                        }

                        return super.onPostScroll(consumed, available, source)
                    }
                }
            }

            Log.d(TAG, "FoodListState: Success: ${result.list}")
            offset += result.list.size
            LazyColumn(
                modifier = Modifier.nestedScroll(nestedScrollConnection),
                state = scrollState,
            ) {
                itemsIndexed(result.list.toList()) { index, model ->

                    model?.let { FoodListItem(index = index, model = it) }
                }
            }
        }

        is FoodListState.Empty -> {
            Log.d(TAG, "FoodListState: Empty")
        }

        is FoodListState.Error -> {
            Log.e(TAG, "FoodListState: Error: ${result.errorMsg}")
        }
    }
}