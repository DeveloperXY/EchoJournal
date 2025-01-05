package com.developerxy.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.icons.Add
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme

@Composable
fun EchoJournalFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        modifier = modifier
            .background(
                shape = CircleShape,
                brush = Brush.verticalGradient(
                    0.0f to colorsScheme().btnGradientStart, 1f to colorsScheme().btnGradientEnd,
                )
            )
            .shadow(
                elevation = 16.dp,
                shape = CircleShape,
                spotColor = colorsScheme().btnGradientEnd,
            ),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.requiredSize(24.dp),
            imageVector = EchoJournalIcons.Add,
            contentDescription = "Add",
            tint = colorsScheme().onPrimary
        )
    }
}

@Preview
@Composable
fun EchoJournalFloatingActionButtonPreview(modifier: Modifier = Modifier) {
    EchoJournalTheme {
        EchoJournalFloatingActionButton()
    }
}