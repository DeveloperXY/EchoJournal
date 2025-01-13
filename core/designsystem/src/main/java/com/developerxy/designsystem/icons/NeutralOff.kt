package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.NeutralOff: ImageVector
    get() {
        if (_NeutralOff != null) {
            return _NeutralOff!!
        }
        _NeutralOff = ImageVector.Builder(
            name = "NeutralOff",
            defaultWidth = 40.dp,
            defaultHeight = 40.dp,
            viewportWidth = 40f,
            viewportHeight = 40f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f
            ) {
                moveTo(17.5f, 2.25f)
                lineTo(22.5f, 2.25f)
                arcTo(15.25f, 15.25f, 0f, isMoreThanHalf = false, isPositiveArc = true, 37.75f, 17.5f)
                lineTo(37.75f, 22.5f)
                arcTo(15.25f, 15.25f, 0f, isMoreThanHalf = false, isPositiveArc = true, 22.5f, 37.75f)
                lineTo(17.5f, 37.75f)
                arcTo(15.25f, 15.25f, 0f, isMoreThanHalf = false, isPositiveArc = true, 2.25f, 22.5f)
                lineTo(2.25f, 17.5f)
                arcTo(15.25f, 15.25f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17.5f, 2.25f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(25f, 13.969f)
                curveTo(27.037f, 14.389f, 28.376f, 15.561f, 29.06f, 17.525f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(14.06f, 13.969f)
                curveTo(12.023f, 14.389f, 10.684f, 15.561f, 10f, 17.525f)
            }
            path(
                stroke = SolidColor(Color(0xFF9FABCD)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round
            ) {
                moveTo(12.5f, 26.25f)
                curveTo(14.063f, 26.806f, 17f, 27.5f, 20f, 27.5f)
                curveTo(23f, 27.5f, 26.563f, 26.806f, 27.5f, 26.25f)
            }
        }.build()

        return _NeutralOff!!
    }

@Suppress("ObjectPropertyName")
private var _NeutralOff: ImageVector? = null
