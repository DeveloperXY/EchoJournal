package com.developerxy.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.icons.Play
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography

@Composable
fun AudioBarVisualizer(
    amplitudes: List<Float>, // Amplitude values (scaled between 0 and 1)
    barColor: Color = colorsScheme().inversePrimary, // Color of the bars
    modifier: Modifier = Modifier,
    maxBarHeight: Dp = 24.dp, // Width of each bar
    barWidth: Dp = 4.dp, // Width of each bar
    barSpacing: Dp = 2.dp, // Spacing between bars
    cornerRadius: Dp = 4.dp, // Rounded corners for bars,
) {
    Canvas(modifier = modifier.height(maxBarHeight)) {
        clipRect {
            amplitudes.forEachIndexed { index, amplitude ->
                val barHeight = amplitude * maxBarHeight.toPx()
                val xOffset = index * (barWidth.toPx() + barSpacing.toPx())
                val yOffset = (maxBarHeight.toPx() - barHeight) / 2

                drawRoundRect(
                    color = barColor,
                    topLeft = androidx.compose.ui.geometry.Offset(
                        xOffset,
                        yOffset
                    ),
                    size = androidx.compose.ui.geometry.Size(barWidth.toPx(), barHeight),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(
                        cornerRadius.toPx(),
                        cornerRadius.toPx()
                    )
                )
            }
        }
    }
}

@Composable
fun EchoJournalMemoPlayer(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(percent = 50))
            .background(colorsScheme().inverseOnSurface),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            IconButton(
                modifier = Modifier
                    .shadow(
                        elevation = 16.dp,
                        shape = MaterialTheme.shapes.medium,
                        ambientColor = Color.Black.copy(alpha = 0.4f),
                        spotColor = Color.Black.copy(alpha = 0.4f)
                    )
                    .clip(CircleShape)
                    .background(Color.White),
                onClick = {}) {
                Icon(
                    modifier = Modifier.requiredSize(32.dp),
                    imageVector = EchoJournalIcons.Play,
                    contentDescription = "play memo",
                    tint = colorsScheme().primary
                )
            }

//            val sampleAmplitudes = List(50) { (0..100).random() / 100f }
            val sampleAmplitudes = listOf(
                1f,
                0.8f,
                0.7f,
                0.6f,
                0.5f,
                0.8f,
                0.7f,
                0.6f,
                0.3f,
                1f,
                0.8f,
                0.7f,
                0.6f,
                0.5f,
                1f,
                0.8f,
                0.7f,
                0.6f,
                0.5f,
                0.8f,
                0.7f,
                0.6f,
                0.3f,
                1f,
                0.8f,
                0.7f,
                0.6f,
                0.5f,
            )
            AudioBarVisualizer(
                amplitudes = sampleAmplitudes,
                modifier = Modifier.weight(1f),
            )

            Text(
                text = "0:00/12:30",
                style = typography().bodySmall,
                color = colorsScheme().onSurfaceVariant
            )
        }
    }
}

@Preview
@Composable
private fun EchoJournalMemoPlayerPreview(modifier: Modifier = Modifier) {
    EchoJournalMemoPlayer()
}