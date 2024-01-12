package com.brainvire.mvvm_clean_arch.presentation.shahen.component

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.brainvire.mvvm_clean_arch.presentation.shahen.login.LoginViewModel

@Composable
fun SnakeBar(scaffoldState: ScaffoldState, message: String, viewModel: LoginViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = message) {
        scaffoldState.snackbarHostState.showSnackbar(
            message = message,
        )

        viewModel.setLoginErrorMsg("")
    }
}