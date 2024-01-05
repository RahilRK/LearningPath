package com.brainvire.mvvm_clean_arch.presentation.shahen.component

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color

@Preview
@Composable
fun LoadingDialog() {

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 600 // animation duration
            }
        ), label = ""
    )

    Dialog(onDismissRequest = { /*TODO*/ }) {
        CircularProgressIndicator(
            progress = 1f,
            modifier = Modifier
                .size(50.dp)
                .rotate(angle)
                .border(
                    12.dp,
                    brush = Brush.sweepGradient(
                        listOf(
                            Color.White, // add background color first
                            shahen_app_color.copy(alpha = 0.1f),
                            shahen_app_color
                        )
                    ),
                    shape = CircleShape
                ),
            strokeWidth = 1.dp,
            color = Color.White // Set background color
        )
    }
}