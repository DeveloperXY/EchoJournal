package com.developerxy.mood_settings.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography
import com.developerxy.mood_settings.DefaultMoodState
import com.developerxy.mood_settings.MoodEntry
import com.developerxy.ui.noRippleClickable

@Composable
fun MoodToggles(
    moodEntries: List<MoodEntry>,
    onMoodToggled: (mood: MoodEntry) -> Unit = {}
) {
    val currentOnMoodToggled by rememberUpdatedState(onMoodToggled)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        for (entry in moodEntries) {
            MoodToggle(
                icon = if (entry.isSelected) entry.selectedIcon else entry.unselectedIcon,
                text = entry.text,
                isSelected = entry.isSelected,
                onClick = { currentOnMoodToggled(entry) }
            )
        }
    }
}

@Composable
private fun MoodToggle(
    icon: ImageVector,
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.noRippleClickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.requiredSize(42.dp),
            imageVector = icon,
            contentDescription = text
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = text,
            style = typography().bodySmall,
            color = if (isSelected) colorsScheme().onSurface else
                colorsScheme().onSurfaceVariant.copy(alpha = 0.6f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoodTogglesPreview() {
    EchoJournalTheme {
        MoodToggles(
            moodEntries = DefaultMoodState().entries
        )
    }
}