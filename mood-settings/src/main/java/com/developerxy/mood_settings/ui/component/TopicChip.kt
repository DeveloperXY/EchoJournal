package com.developerxy.mood_settings.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography

@Composable
fun TopicChip(
    modifier: Modifier = Modifier,
    topic: String,
    onDelete: () -> Unit = {},
) {
    FilterChip(
        modifier = modifier,
        selected = true,
        onClick = {},
        shape = MaterialTheme.shapes.large,
        colors = FilterChipDefaults.filterChipColors()
            .copy(selectedContainerColor = Color(0xFFF2F2F7)),
        leadingIcon = {
            Text(
                text = "#",
                style = typography().button,
                color = colorsScheme().onSurfaceVariant.copy(alpha = 0.3f)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Outlined.Close,
                modifier = Modifier
                    .size(16.dp)
                    .clickable { onDelete() },
                contentDescription = "Delete",
                tint = colorsScheme().onSurfaceVariant.copy(alpha = 0.3f),
            )
        },
        label = {
            Text(
                text = topic,
                style = typography().button,
                color = colorsScheme().onSurfaceVariant,
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    )
}

@Preview
@Composable
private fun TopicChipPreview(modifier: Modifier = Modifier) {
    TopicChip(
        topic = "WWE",
        onDelete = {}
    )
}