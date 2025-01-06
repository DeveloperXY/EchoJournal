package com.developerxy.mood_record_audio.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.icons.Play
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme

@Composable
fun PlayButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector = EchoJournalIcons.Play,
    contentDescription: String? = null,
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier
            .requiredSize(48.dp)
            .clip(CircleShape)
            .background(colorsScheme().onPrimaryContainer),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.requiredSize(24.dp),
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = colorsScheme().primary
        )
    }
}

@Preview
@Composable
private fun PlayButtonPreview() {
    EchoJournalTheme {
        PlayButton()
    }
}