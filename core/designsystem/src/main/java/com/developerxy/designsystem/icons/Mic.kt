package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.Mic: ImageVector
    get() {
        if (_Mic != null) {
            return _Mic!!
        }
        _Mic = ImageVector.Builder(
            name = "Mic",
            defaultWidth = 32.dp,
            defaultHeight = 32.dp,
            viewportWidth = 32f,
            viewportHeight = 32f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(0f, 0f)
                horizontalLineToRelative(32f)
                verticalLineToRelative(32f)
                horizontalLineToRelative(-32f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(16f, 18.667f)
                curveTo(14.889f, 18.667f, 13.944f, 18.278f, 13.167f, 17.5f)
                curveTo(12.389f, 16.722f, 12f, 15.778f, 12f, 14.667f)
                verticalLineTo(6.667f)
                curveTo(12f, 5.556f, 12.389f, 4.611f, 13.167f, 3.833f)
                curveTo(13.944f, 3.056f, 14.889f, 2.667f, 16f, 2.667f)
                curveTo(17.111f, 2.667f, 18.056f, 3.056f, 18.833f, 3.833f)
                curveTo(19.611f, 4.611f, 20f, 5.556f, 20f, 6.667f)
                verticalLineTo(14.667f)
                curveTo(20f, 15.778f, 19.611f, 16.722f, 18.833f, 17.5f)
                curveTo(18.056f, 18.278f, 17.111f, 18.667f, 16f, 18.667f)
                close()
                moveTo(14.667f, 28f)
                verticalLineTo(23.9f)
                curveTo(12.356f, 23.589f, 10.444f, 22.556f, 8.933f, 20.8f)
                curveTo(7.422f, 19.044f, 6.667f, 17f, 6.667f, 14.667f)
                horizontalLineTo(9.333f)
                curveTo(9.333f, 16.511f, 9.983f, 18.083f, 11.283f, 19.383f)
                curveTo(12.583f, 20.683f, 14.156f, 21.333f, 16f, 21.333f)
                curveTo(17.844f, 21.333f, 19.417f, 20.683f, 20.717f, 19.383f)
                curveTo(22.017f, 18.083f, 22.667f, 16.511f, 22.667f, 14.667f)
                horizontalLineTo(25.333f)
                curveTo(25.333f, 17f, 24.578f, 19.044f, 23.067f, 20.8f)
                curveTo(21.556f, 22.556f, 19.645f, 23.589f, 17.333f, 23.9f)
                verticalLineTo(28f)
                horizontalLineTo(14.667f)
                close()
            }
        }.build()

        return _Mic!!
    }

@Suppress("ObjectPropertyName")
private var _Mic: ImageVector? = null
