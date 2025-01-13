package com.developerxy.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.ExcitedOn: ImageVector
    get() {
        if (_ExcitedOn != null) {
            return _ExcitedOn!!
        }
        _ExcitedOn = ImageVector.Builder(
            name = "ExcitedOn",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFF5CB6F),
                        1f to Color(0xFFF6B01A)
                    ),
                    start = Offset(16f, 0f),
                    end = Offset(16f, 32f)
                )
            ) {
                moveTo(31f, 14f)
                curveTo(31f, 22.837f, 26f, 32f, 16f, 32f)
                curveTo(6f, 32f, 0f, 22.837f, 0f, 14f)
                curveTo(0f, 5.163f, 7.163f, 0f, 16f, 0f)
                curveTo(24.837f, 0f, 31f, 5.163f, 31f, 14f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF191A20)),
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(24f, 17f)
                curveTo(23.167f, 18.833f, 21.725f, 22f, 18.5f, 22f)
                curveTo(15.5f, 22f, 13.5f, 18.5f, 13f, 17f)
                lineTo(24f, 17f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(23f, 9.67f)
                lineTo(26.252f, 12.9f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(13.252f, 9.67f)
                lineTo(10f, 12.9f)
            }
        }.build()

        return _ExcitedOn!!
    }

@Suppress("ObjectPropertyName")
private var _ExcitedOn: ImageVector? = null
