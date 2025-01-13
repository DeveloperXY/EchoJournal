package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.StressedOff: ImageVector
    get() {
        if (_StressedOff != null) {
            return _StressedOff!!
        }
        _StressedOff = ImageVector.Builder(
            name = "StressedOff",
            defaultWidth = 41.dp,
            defaultHeight = 44.dp,
            viewportWidth = 41f,
            viewportHeight = 44f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f
            ) {
                moveTo(21f, 43f)
                curveTo(26.819f, 43f, 31.477f, 40.63f, 34.663f, 36.78f)
                curveTo(37.832f, 32.948f, 39.5f, 27.709f, 39.5f, 22f)
                curveTo(39.5f, 10.497f, 30.392f, 1f, 21f, 1f)
                curveTo(16.301f, 1f, 11.37f, 3.39f, 7.634f, 7.153f)
                curveTo(3.887f, 10.927f, 1.25f, 16.17f, 1.25f, 22f)
                curveTo(1.25f, 33.511f, 9.319f, 43f, 21f, 43f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(11f, 29.5f)
                curveTo(12.042f, 27.208f, 13.844f, 23.25f, 17.875f, 23.25f)
                curveTo(21.625f, 23.25f, 24.125f, 27.625f, 24.75f, 29.5f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(23.5f, 18.25f)
                lineTo(29.75f, 14.5f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(7.25f, 14.5f)
                lineTo(13.5f, 18.25f)
            }
        }.build()

        return _StressedOff!!
    }

@Suppress("ObjectPropertyName")
private var _StressedOff: ImageVector? = null
