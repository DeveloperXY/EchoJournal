package com.developerxy.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EchoJournalCard(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit = {}
) {
    Box(
        modifier = modifier
            .shadow(elevation = 8.dp,
                shape = MaterialTheme.shapes.medium,
                ambientColor = Color.Black.copy(alpha = 0.2f),
                spotColor = Color.Black.copy(alpha = 0.2f)
            )
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(Color.White)
    ) {
        content()
    }
}

@Preview
@Composable
private fun EchoJournalCardPreview() {
    EchoJournalCard()
}