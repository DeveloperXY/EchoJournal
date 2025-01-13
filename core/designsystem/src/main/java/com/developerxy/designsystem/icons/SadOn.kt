package com.developerxy.designsystem.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.SadOn: ImageVector
    get() {
        if (_SadOn != null) {
            return _SadOn!!
        }
        _SadOn = ImageVector.Builder(
            name = "SadOn",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(
                fill = Brush.linearGradient(
                    colorStops = arrayOf(
                        0f to Color(0xFF7BBCFA),
                        1f to Color(0xFF2993F7)
                    ),
                    start = Offset(16f, 0f),
                    end = Offset(16f, 32f)
                )
            ) {
                moveTo(32f, 19f)
                curveTo(32f, 27.837f, 24.837f, 32f, 16f, 32f)
                curveTo(7.163f, 32f, 0f, 27.837f, 0f, 19f)
                curveTo(0f, 10.163f, 7.163f, 0f, 16f, 0f)
                curveTo(24.837f, 0f, 32f, 10.163f, 32f, 19f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(19f, 24.078f)
                curveTo(18.118f, 22.975f, 15.445f, 20.836f, 11.815f, 21.101f)
                curveTo(8.185f, 21.365f, 7.378f, 23.196f, 7f, 24.078f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(8.226f, 11.479f)
                curveTo(7.968f, 12.916f, 6.453f, 14.311f, 5f, 14.45f)
            }
            path(
                stroke = SolidColor(Color(0xFF191A20)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(16.402f, 11.184f)
                curveTo(16.496f, 12.64f, 17.844f, 14.198f, 19.272f, 14.5f)
            }
            path(fill = SolidColor(Color(0xFFDFEEFC))) {
                moveTo(22f, 19f)
                curveTo(22f, 19.828f, 21.328f, 20.5f, 20.5f, 20.5f)
                curveTo(19.672f, 20.5f, 19f, 19.828f, 19f, 19f)
                curveTo(19f, 18.172f, 20.5f, 16f, 20.5f, 16f)
                curveTo(20.5f, 16f, 22f, 18.172f, 22f, 19f)
                close()
            }
        }.build()

        return _SadOn!!
    }

@Suppress("ObjectPropertyName")
private var _SadOn: ImageVector? = null
