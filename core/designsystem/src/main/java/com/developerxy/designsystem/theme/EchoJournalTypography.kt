package com.developerxy.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.developerxy.designsystem.R

@Immutable
data class EchoJournalTypography(
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val headlineSmall: TextStyle,
    val headlineExtraSmall: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val buttonLarge: TextStyle,
    val button: TextStyle,
    val labelMedium: TextStyle,
) {
    fun toTypography(): Typography {
        return Typography(
            headlineLarge = headlineLarge,
            headlineMedium = headlineLarge,
            headlineSmall = headlineLarge,
            bodyMedium = bodyMedium,
            bodySmall = bodySmall,
            labelMedium = labelMedium
        )
    }
}

val Inter = FontFamily(
    Font(resId = R.font.inter_regular, weight = FontWeight.Normal),
    Font(resId = R.font.inter_medium, weight = FontWeight.Medium),
)

val InterMedium = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
)
val InterRegular = TextStyle(
    fontFamily = Inter,
    fontWeight = FontWeight.Medium,
)

val DefaultEchoJournalTypography = EchoJournalTypography(
    headlineLarge = InterMedium.copy(
        color = DefaultEchoJournalColorScheme.onSurface,
        fontSize = 26.sp,
        lineHeight = 32.sp,
    ),
    headlineMedium = InterMedium.copy(
        fontSize = 22.sp,
        lineHeight = 26.sp,
    ),
    headlineSmall = InterMedium.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    headlineExtraSmall = InterMedium.copy(
        fontSize = 13.sp,
        lineHeight = 18.sp,
    ),
    bodyMedium = InterRegular.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = InterRegular.copy(
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    buttonLarge = InterMedium.copy(
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    button = InterMedium.copy(
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    labelMedium = InterMedium.copy(
        fontSize = 12.sp,
    ),
)