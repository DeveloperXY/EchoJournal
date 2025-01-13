package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.SadOff: ImageVector
    get() {
        if (_SadOff != null) {
            return _SadOff!!
        }
        _SadOff = ImageVector.Builder(
            name = "SadOff",
            defaultWidth = 44.dp,
            defaultHeight = 44.dp,
            viewportWidth = 44f,
            viewportHeight = 44f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f
            ) {
                moveTo(22f, 43f)
                curveTo(27.663f, 43f, 32.894f, 41.668f, 36.737f, 38.821f)
                curveTo(40.619f, 35.945f, 43f, 31.58f, 43f, 25.75f)
                curveTo(43f, 19.977f, 40.669f, 13.825f, 36.925f, 9.111f)
                curveTo(33.183f, 4.4f, 27.922f, 1f, 22f, 1f)
                curveTo(16.078f, 1f, 10.817f, 4.4f, 7.075f, 9.111f)
                curveTo(3.331f, 13.825f, 1f, 19.977f, 1f, 25.75f)
                curveTo(1f, 31.58f, 3.381f, 35.945f, 7.263f, 38.821f)
                curveTo(11.106f, 41.668f, 16.337f, 43f, 22f, 43f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(25.75f, 32.098f)
                curveTo(24.647f, 30.719f, 21.307f, 28.045f, 16.769f, 28.376f)
                curveTo(12.231f, 28.707f, 11.223f, 30.995f, 10.75f, 32.098f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(12.283f, 16.349f)
                curveTo(11.96f, 18.144f, 10.066f, 19.889f, 8.25f, 20.062f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(22.503f, 15.979f)
                curveTo(22.62f, 17.8f, 24.305f, 19.747f, 26.09f, 20.125f)
            }
            path(fill = SolidColor(Color(0xFF9FABCD))) {
                moveTo(29.5f, 25.75f)
                curveTo(29.5f, 26.785f, 28.66f, 27.625f, 27.625f, 27.625f)
                curveTo(26.59f, 27.625f, 25.75f, 26.785f, 25.75f, 25.75f)
                curveTo(25.75f, 24.715f, 27.625f, 22f, 27.625f, 22f)
                curveTo(27.625f, 22f, 29.5f, 24.715f, 29.5f, 25.75f)
                close()
            }
        }.build()

        return _SadOff!!
    }

@Suppress("ObjectPropertyName")
private var _SadOff: ImageVector? = null
