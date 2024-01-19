package com.brainvire.mvvm_clean_arch.presentation.learning_compose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WholeComposeScreen() {
    Box(
        Modifier
            .fillMaxSize().background(Color.Black.copy(alpha = 0.25f))
    ) {
        Text(text = "WholeComposeScreen", modifier = Modifier.align(Alignment.Center))
    }
}