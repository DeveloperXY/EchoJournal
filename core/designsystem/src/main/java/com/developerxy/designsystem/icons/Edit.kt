package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.Edit: ImageVector
    get() {
        if (_Edit != null) {
            return _Edit!!
        }
        _Edit = ImageVector.Builder(
            name = "Edit",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(2f, 11.5f)
                verticalLineTo(14f)
                horizontalLineTo(4.5f)
                lineTo(11.873f, 6.627f)
                lineTo(9.373f, 4.127f)
                lineTo(2f, 11.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(13.807f, 3.753f)
                lineTo(12.247f, 2.193f)
                curveTo(11.987f, 1.933f, 11.567f, 1.933f, 11.307f, 2.193f)
                lineTo(10.087f, 3.413f)
                lineTo(12.587f, 5.913f)
                lineTo(13.807f, 4.693f)
                curveTo(14.067f, 4.433f, 14.067f, 4.013f, 13.807f, 3.753f)
                close()
            }
        }.build()

        return _Edit!!
    }

@Suppress("ObjectPropertyName")
private var _Edit: ImageVector? = null
