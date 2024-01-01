package com.brainvire.mvvm_clean_arch.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brainvire.mvvm_clean_arch.domain.usecase.CategoryUseCase
import com.brainvire.mvvm_clean_arch.presentation.home.state.HomeStateHandler
import com.brainvire.mvvm_clean_arch.util.ResponseHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
) : ViewModel() {

    var TAG = "HomeViewModel"

    private val _categoryState = MutableStateFlow(HomeStateHandler())
    val categoryState: StateFlow<HomeStateHandler> = _categoryState

    init {
        getCategoryList()
    }

    //todo meal
    fun getCategoryList() {
        categoryUseCase.invoke().onEach { result ->
            when (result) {
                is ResponseHandler.Success -> {
                    _categoryState.value = result.data?.let { HomeStateHandler(data = it) }!!
                }
                is ResponseHandler.Error -> {
                    _categoryState.value = HomeStateHandler(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is ResponseHandler.Loading -> {
                    _categoryState.value = HomeStateHandler(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}