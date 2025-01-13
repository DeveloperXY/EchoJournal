package com.developerxy.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.PeacefulOn: ImageVector
    get() {
        if (_PeacefulOn != null) {
            return _PeacefulOn!!
        }
        _PeacefulOn = ImageVector.Builder(
            name = "PeacefulOn",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFFFCCDEE),
                        1f to Color(0xFFF991E0)
                    ),
                    start = Offset(16f, 0f),
                    end = Offset(16f, 32f)
                )
            ) {
                moveTo(32f, 16f)
                curveTo(32f, 24.837f, 25.837f, 30f, 17f, 30f)
                curveTo(8.163f, 30f, 0f, 24.837f, 0f, 16f)
                curveTo(0f, 7.163f, 8.163f, 1f, 17f, 1f)
                curveTo(25.837f, 1f, 32f, 7.163f, 32f, 16f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(12f, 21f)
                curveTo(13.029f, 22.47f, 14.75f, 25f, 19f, 25f)
                curveTo(23.5f, 25f, 25.559f, 22.176f, 26f, 21f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(23f, 12.037f)
                curveTo(23.566f, 13.601f, 25.538f, 14.877f, 27.198f, 14.753f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(15.198f, 12.037f)
                curveTo(14.631f, 13.601f, 12.66f, 14.877f, 11f, 14.753f)
            }
        }.build()

        return _PeacefulOn!!
    }

@Suppress("ObjectPropertyName")
private var _PeacefulOn: ImageVector? = null
