package com.brainvire.mvvm_clean_arch.presentation.shahen.more

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brainvire.mvvm_clean_arch.presentation.shahen.component.TopBar
import com.brainvire.mvvm_clean_arch.presentation.shahen.more.component.MoreCard
import com.brainvire.mvvm_clean_arch.presentation.shahen.more.component.MoreOptionCard

@Preview(showSystemUi = true)
@Composable
fun More() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(
            showTitle = true,
            title = "More"
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            MoreCard(
                title = "Language",
                showChangeLanguageBtn = true
            )

            MoreOptionCard(modifier = Modifier.padding(top = 16.dp))
        }
    }
}