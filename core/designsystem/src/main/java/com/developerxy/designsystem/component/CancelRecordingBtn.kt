package com.developerxy.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.icons.Close
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme

@Composable
fun CancelRecordingBtn(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier
            .requiredSize(48.dp)
            .clip(CircleShape)
            .background(colorsScheme().errorContainer),
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.requiredSize(24.dp),
            imageVector = EchoJournalIcons.Close,
            contentDescription = "Cancel",
            tint = colorsScheme().onErrorContainer
        )
    }
}

@Preview
@Composable
private fun CancelRecordingBtnPreview() {
    EchoJournalTheme {
        CancelRecordingBtn()
    }
}