package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.Add: ImageVector
    get() {
        if (_Add != null) {
            return _Add!!
        }
        _Add = ImageVector.Builder(
            name = "Add",
            defaultWidth = 18.dp,
            defaultHeight = 18.dp,
            viewportWidth = 18f,
            viewportHeight = 18f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(8.25f, 9.75f)
                horizontalLineTo(3.75f)
                verticalLineTo(8.25f)
                horizontalLineTo(8.25f)
                verticalLineTo(3.75f)
                horizontalLineTo(9.75f)
                verticalLineTo(8.25f)
                horizontalLineTo(14.25f)
                verticalLineTo(9.75f)
                horizontalLineTo(9.75f)
                verticalLineTo(14.25f)
                horizontalLineTo(8.25f)
                verticalLineTo(9.75f)
                close()
            }
        }.build()

        return _Add!!
    }

@Suppress("ObjectPropertyName")
private var _Add: ImageVector? = null
