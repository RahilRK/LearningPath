package com.brainvire.mvvm_clean_arch.presentation.shahen.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brainvire.mvvm_clean_arch.presentation.shahen.ui.theme.shahen_app_color


@Preview
@Composable
fun DashedDivider(
    thickness: Dp = 1.dp,
    color: Color = Color.Black,
    phase: Float = 5f,//divider spacing
    intervals: FloatArray = floatArrayOf(10f, 10f),
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
//        modifier = Modifier.fillMaxWidth()
    ) {
        val dividerHeight = thickness.toPx()
        drawRoundRect(
            color = color,
            style = Stroke(
                width = dividerHeight,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = intervals,
                    phase = phase
                )
            )
        )
    }
}