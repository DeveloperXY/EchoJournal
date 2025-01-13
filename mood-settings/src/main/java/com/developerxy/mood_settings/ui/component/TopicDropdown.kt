package com.developerxy.mood_settings.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography

@Composable
fun MyTopicsCardDropdown(
    modifier: Modifier = Modifier,
    selectedTopics: Set<String>,
    savedTopics: Set<String>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit = {},
    onSetAsDefaultAndSaveTopic: (String) -> Unit = {},
    exitAddTopicMode: () -> Unit = {},
    onAddDefaultTopic: (String) -> Unit = {},
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
            .offset(y = -(8.dp))
            .shadow(
                elevation = 8.dp,
                shape = MaterialTheme.shapes.small,
                ambientColor = Color.Black.copy(alpha = 0.4f),
                spotColor = Color.Black.copy(alpha = 0.4f)
            ),
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            val matchingSavedTopics = savedTopics.filter {
                it.startsWith(prefix = searchQuery, ignoreCase = true) && !selectedTopics.contains(
                    it
                )
            }

            matchingSavedTopics.forEach { topic ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(
                            onClick = {
                                onAddDefaultTopic(topic)
                                exitAddTopicMode()
                                onSearchQueryChange("")
                            }
                        )
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "#",
                        textAlign = TextAlign.End,
                        style = typography().button.copy(
                            fontSize = 18.sp
                        ),
                        color = colorsScheme().primary.copy(alpha = 0.5f)
                    )
                    Text(
                        text = topic,
                        style = typography().button,
                        color = colorsScheme().secondary,
                    )
                }
            }

            // Show create option if query doesn't exist in saved topics
            if (!savedTopics.any { it.equals(searchQuery, ignoreCase = true) }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onSetAsDefaultAndSaveTopic(searchQuery)
                            exitAddTopicMode()
                            onSearchQueryChange("")
                        }
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        modifier = Modifier.size(18.dp),
                        contentDescription = null,
                        tint = colorsScheme().primary,
                    )
                    Text(
                        text = "Create $searchQuery",
                        style = MaterialTheme.typography.titleSmall,
                        color = colorsScheme().primary,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TopicDropdownPreview(modifier: Modifier = Modifier) {
    MyTopicsCardDropdown(
        selectedTopics = setOf("politics", "sports", "entertainment"),
        searchQuery = "test",
        savedTopics = setOf("politics"),
    )
}