package com.developerxy.designsystem.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val EchoJournalIcons.Ai: ImageVector
    get() {
        if (_Ai != null) {
            return _Ai!!
        }
        _Ai = ImageVector.Builder(
            name = "Ai",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(3f, 17.3f)
                horizontalLineTo(8.684f)
                verticalLineTo(15.4f)
                horizontalLineTo(3f)
                verticalLineTo(17.3f)
                close()
                moveTo(18.158f, 4f)
                horizontalLineTo(3f)
                verticalLineTo(5.9f)
                horizontalLineTo(18.158f)
                verticalLineTo(4f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000))) {
                moveTo(14.368f, 9.7f)
                horizontalLineTo(3f)
                verticalLineTo(11.6f)
                horizontalLineTo(14.368f)
                verticalLineTo(9.7f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(14.368f, 9.7f)
                curveTo(14.76f, 9.7f, 15.112f, 9.942f, 15.253f, 10.309f)
                lineTo(16.348f, 13.165f)
                curveTo(16.543f, 13.674f, 16.588f, 13.772f, 16.641f, 13.847f)
                curveTo(16.703f, 13.934f, 16.778f, 14.009f, 16.865f, 14.071f)
                curveTo(16.939f, 14.124f, 17.037f, 14.169f, 17.545f, 14.365f)
                lineTo(20.393f, 15.463f)
                curveTo(20.759f, 15.604f, 21f, 15.957f, 21f, 16.35f)
                curveTo(21f, 16.743f, 20.759f, 17.096f, 20.393f, 17.237f)
                lineTo(17.545f, 18.335f)
                curveTo(17.037f, 18.531f, 16.939f, 18.576f, 16.865f, 18.629f)
                curveTo(16.778f, 18.691f, 16.703f, 18.767f, 16.641f, 18.853f)
                curveTo(16.588f, 18.928f, 16.543f, 19.026f, 16.348f, 19.535f)
                lineTo(15.253f, 22.391f)
                curveTo(15.112f, 22.758f, 14.76f, 23f, 14.368f, 23f)
                curveTo(13.976f, 23f, 13.625f, 22.758f, 13.484f, 22.391f)
                lineTo(12.389f, 19.535f)
                curveTo(12.193f, 19.026f, 12.149f, 18.928f, 12.095f, 18.853f)
                curveTo(12.034f, 18.767f, 11.959f, 18.691f, 11.872f, 18.629f)
                curveTo(11.798f, 18.576f, 11.7f, 18.531f, 11.192f, 18.335f)
                lineTo(8.344f, 17.237f)
                curveTo(7.978f, 17.096f, 7.737f, 16.743f, 7.737f, 16.35f)
                curveTo(7.737f, 15.957f, 7.978f, 15.604f, 8.344f, 15.463f)
                lineTo(11.192f, 14.365f)
                curveTo(11.7f, 14.169f, 11.798f, 14.124f, 11.872f, 14.071f)
                curveTo(11.959f, 14.009f, 12.034f, 13.934f, 12.095f, 13.847f)
                curveTo(12.149f, 13.772f, 12.193f, 13.674f, 12.389f, 13.165f)
                lineTo(13.484f, 10.309f)
                curveTo(13.625f, 9.942f, 13.976f, 9.7f, 14.368f, 9.7f)
                close()
                moveTo(14.368f, 13.296f)
                lineTo(14.157f, 13.847f)
                curveTo(14.147f, 13.873f, 14.137f, 13.9f, 14.127f, 13.926f)
                curveTo(13.979f, 14.312f, 13.849f, 14.652f, 13.64f, 14.948f)
                curveTo(13.455f, 15.208f, 13.229f, 15.434f, 12.97f, 15.619f)
                curveTo(12.675f, 15.829f, 12.336f, 15.96f, 11.951f, 16.108f)
                curveTo(11.925f, 16.118f, 11.899f, 16.128f, 11.872f, 16.138f)
                lineTo(11.323f, 16.35f)
                lineTo(11.872f, 16.562f)
                curveTo(11.899f, 16.572f, 11.925f, 16.582f, 11.951f, 16.592f)
                curveTo(12.336f, 16.74f, 12.675f, 16.871f, 12.97f, 17.081f)
                curveTo(13.229f, 17.265f, 13.455f, 17.492f, 13.64f, 17.752f)
                curveTo(13.849f, 18.048f, 13.979f, 18.388f, 14.127f, 18.774f)
                curveTo(14.137f, 18.8f, 14.147f, 18.827f, 14.157f, 18.853f)
                lineTo(14.368f, 19.404f)
                lineTo(14.58f, 18.853f)
                curveTo(14.59f, 18.827f, 14.6f, 18.8f, 14.61f, 18.774f)
                curveTo(14.757f, 18.388f, 14.888f, 18.048f, 15.097f, 17.752f)
                curveTo(15.281f, 17.492f, 15.508f, 17.265f, 15.767f, 17.081f)
                curveTo(16.061f, 16.871f, 16.401f, 16.74f, 16.786f, 16.592f)
                curveTo(16.812f, 16.582f, 16.838f, 16.572f, 16.865f, 16.562f)
                lineTo(17.414f, 16.35f)
                lineTo(16.865f, 16.138f)
                curveTo(16.838f, 16.128f, 16.812f, 16.118f, 16.786f, 16.108f)
                curveTo(16.401f, 15.96f, 16.061f, 15.829f, 15.767f, 15.619f)
                curveTo(15.508f, 15.434f, 15.281f, 15.208f, 15.097f, 14.948f)
                curveTo(14.888f, 14.652f, 14.757f, 14.312f, 14.61f, 13.926f)
                curveTo(14.6f, 13.9f, 14.59f, 13.873f, 14.58f, 13.847f)
                lineTo(14.368f, 13.296f)
                close()
            }
        }.build()

        return _Ai!!
    }

@Suppress("ObjectPropertyName")
private var _Ai: ImageVector? = null
