package com.brainvire.mvvm_clean_arch.presentation.shahen.component

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SnakeBar(scaffoldState: ScaffoldState, message: String) {
    LaunchedEffect(key1 = message) {
        scaffoldState.snackbarHostState.showSnackbar(
            message = message,
        )
    }
}