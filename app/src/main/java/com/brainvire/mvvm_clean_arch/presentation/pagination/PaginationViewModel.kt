package com.brainvire.mvvm_clean_arch.presentation.pagination

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.model.response.food2fork.RespFood2Fork
import com.brainvire.mvvm_clean_arch.domain.usecase.food2fork.FoodListUseCase
import com.brainvire.mvvm_clean_arch.presentation.pagination.state.FoodListState
import com.brainvire.mvvm_clean_arch.util.ResponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaginationViewModel @Inject constructor(
    private val foodListUseCase: FoodListUseCase,
    val preferenceManager: PreferenceManager
) : ViewModel() {

    var TAG = "PaginationViewModel"

    private val _getFoodListState =
        MutableStateFlow<FoodListState>(FoodListState.Loading)
    val getFoodListState: StateFlow<FoodListState>
        get() = _getFoodListState

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading.asStateFlow()

    fun setIsLoading(value: Boolean = false) {
        _isLoading.value = value
    }

    private val _page = MutableStateFlow(1)
    val page: StateFlow<Int>
        get() = _page.asStateFlow()

    fun setPageNumber(value: Int = 1) {

        _page.value = page.value + value
    }

    private val _offset = MutableStateFlow(0)
    val offset: StateFlow<Int>
        get() = _offset.asStateFlow()

    private val _foodList: MutableList<RespFood2Fork.Result?> = mutableStateListOf()
    var foodList: List<RespFood2Fork.Result?> = _foodList
    init {
        getFoodList()
    }

    fun getFoodList() {
        Log.d(TAG, "getFoodList: API call page: ${page.value}")
        foodListUseCase.invoke(page = page.value, query = "").onEach { result ->
            when (result) {
                is ResponseHandler.Loading -> {

                    setIsLoading(value = true)
                    _getFoodListState.emit(FoodListState.Loading)
                }

                is ResponseHandler.Success -> {

                    setIsLoading(value = false)
                    val list = result.data?.results?.toMutableStateList()
                    if (list.isNullOrEmpty()) {
                        _getFoodListState.emit(FoodListState.Empty)
                    } else {
                        if(page.value == 1) {
                            _foodList.addAll(list.toMutableList())
                            _getFoodListState.emit(FoodListState.Success(list = foodList.toMutableStateList(), isLoadMore = false))
                        }
                        else if(page.value > 1) {
                            _foodList.addAll(list.toMutableList())
                            Log.d(TAG, "getFoodList: ${foodList.size}")
                            _getFoodListState.emit(FoodListState.Success(list = foodList.toMutableStateList(), isLoadMore = true))
                        }
                        _offset.emit(_offset.value + list.size)
                        Log.d(TAG, "getFoodList: API call offset: ${offset.value}")
                    }
                }

                is ResponseHandler.Error<*> -> {

                    setIsLoading(value = false)
                    _getFoodListState.emit(
                        FoodListState.Error(
                            errorMsg = result.message ?: "An unexpected error occurred"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
