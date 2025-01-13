package com.developerxy.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.StressedOn: ImageVector
    get() {
        if (_StressedOn != null) {
            return _StressedOn!!
        }
        _StressedOn = ImageVector.Builder(
            name = "StressedOn",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF69193),
                        1f to Color(0xFFED3A3A)
                    ),
                    start = Offset(16f, 0f),
                    end = Offset(16f, 32f)
                )
            ) {
                moveTo(30f, 16f)
                curveTo(30f, 24.837f, 24.837f, 32f, 16f, 32f)
                curveTo(7.163f, 32f, 1f, 24.837f, 1f, 16f)
                curveTo(1f, 7.163f, 9f, 0f, 16f, 0f)
                curveTo(23f, 0f, 30f, 7.163f, 30f, 16f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(8f, 22f)
                curveTo(8.833f, 20.167f, 10.275f, 17f, 13.5f, 17f)
                curveTo(16.5f, 17f, 18.5f, 20.5f, 19f, 22f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(18f, 13f)
                lineTo(23f, 10f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(5f, 10f)
                lineTo(10f, 13f)
            }
        }.build()

        return _StressedOn!!
    }

@Suppress("ObjectPropertyName")
private var _StressedOn: ImageVector? = null
