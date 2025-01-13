package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.ExcitedOff: ImageVector
    get() {
        if (_ExcitedOff != null) {
            return _ExcitedOff!!
        }
        _ExcitedOff = ImageVector.Builder(
            name = "ExcitedOff",
            defaultWidth = 43.dp,
            defaultHeight = 44.dp,
            viewportWidth = 43f,
            viewportHeight = 44f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f
            ) {
                moveTo(22f, 43f)
                curveTo(28.598f, 43f, 33.573f, 39.96f, 36.868f, 35.485f)
                curveTo(40.142f, 31.038f, 41.75f, 25.195f, 41.75f, 19.5f)
                curveTo(41.75f, 13.731f, 39.73f, 9.074f, 36.188f, 5.867f)
                curveTo(32.659f, 2.671f, 27.713f, 1f, 22f, 1f)
                curveTo(16.291f, 1f, 11.052f, 2.668f, 7.22f, 5.837f)
                curveTo(3.37f, 9.023f, 1f, 13.681f, 1f, 19.5f)
                curveTo(1f, 30.891f, 8.761f, 43f, 22f, 43f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF9FABCD)),
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(32f, 23.25f)
                curveTo(30.958f, 25.542f, 29.156f, 29.5f, 25.125f, 29.5f)
                curveTo(21.375f, 29.5f, 18.875f, 25.125f, 18.25f, 23.25f)
                lineTo(32f, 23.25f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(30.75f, 14.087f)
                lineTo(34.815f, 18.125f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(18.566f, 14.087f)
                lineTo(14.5f, 18.125f)
            }
        }.build()

        return _ExcitedOff!!
    }

@Suppress("ObjectPropertyName")
private var _ExcitedOff: ImageVector? = null
