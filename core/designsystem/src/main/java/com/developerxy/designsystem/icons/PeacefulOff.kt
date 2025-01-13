package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.PeacefulOff: ImageVector
    get() {
        if (_PeacefulOff != null) {
            return _PeacefulOff!!
        }
        _PeacefulOff = ImageVector.Builder(
            name = "PeacefulOff",
            defaultWidth = 44.dp,
            defaultHeight = 41.dp,
            viewportWidth = 44f,
            viewportHeight = 41f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f
            ) {
                moveTo(23.25f, 39.5f)
                curveTo(28.963f, 39.5f, 33.909f, 37.829f, 37.438f, 34.633f)
                curveTo(40.98f, 31.426f, 43f, 26.769f, 43f, 21f)
                curveTo(43f, 15.238f, 40.987f, 10.288f, 37.474f, 6.776f)
                curveTo(33.962f, 3.263f, 29.011f, 1.25f, 23.25f, 1.25f)
                curveTo(11.821f, 1.25f, 1f, 9.247f, 1f, 21f)
                curveTo(1f, 26.867f, 3.724f, 31.525f, 7.877f, 34.688f)
                curveTo(12.01f, 37.835f, 17.545f, 39.5f, 23.25f, 39.5f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(17f, 27.25f)
                curveTo(18.287f, 29.088f, 20.438f, 32.25f, 25.75f, 32.25f)
                curveTo(31.375f, 32.25f, 33.949f, 28.72f, 34.5f, 27.25f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(30.75f, 16.046f)
                curveTo(31.458f, 18.002f, 33.923f, 19.597f, 35.997f, 19.442f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(20.997f, 16.046f)
                curveTo(20.289f, 18.002f, 17.824f, 19.597f, 15.75f, 19.442f)
            }
        }.build()

        return _PeacefulOff!!
    }

@Suppress("ObjectPropertyName")
private var _PeacefulOff: ImageVector? = null
