package com.developerxy.mood_settings.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipFlowRow(
    modifier: Modifier = Modifier,
    selectedTopics: Set<String>,
    onDeleteTopic: (String) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    isInAddTopicMode: Boolean,
    enterAddTopicMode: () -> Unit,
    exitAddTopicMode: () -> Unit,
    keyboardController: SoftwareKeyboardController?,
    focusRequester: FocusRequester
) {
    LaunchedEffect(isInAddTopicMode) {
        if (isInAddTopicMode.not()) return@LaunchedEffect
        focusRequester.requestFocus()
        keyboardController?.show()
    }

    FlowRow(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        selectedTopics.forEach { topic ->
            TopicChip(
                modifier = Modifier.padding(end = 4.dp),
                topic = topic,
                onDelete = { onDeleteTopic(topic) }
            )
        }

        if (isInAddTopicMode.not()) {
            IconButton(
                onClick = enterAddTopicMode,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .background(color = Color(0xFFF2F2F7), shape = CircleShape)
                    .size(32.dp),
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFF40434F),
                    )
                }
            )
        } else {
            BasicTextField(
                value = searchQuery,
                textStyle = typography().bodyMedium.copy(
                    color = colorsScheme().onSurface
                ),
                onValueChange = { onSearchQueryChange(it) },
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(vertical = 8.dp)
                    .focusRequester(focusRequester),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        exitAddTopicMode()
                        keyboardController?.hide()
                    }
                ),
            )
        }
    }
}