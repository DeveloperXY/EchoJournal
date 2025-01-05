@file:OptIn(ExperimentalMaterial3Api::class)

package com.developerxy.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developerxy.designsystem.R
import com.developerxy.designsystem.icons.ArrowBack
import com.developerxy.designsystem.icons.EchoJournalIcons
import com.developerxy.designsystem.icons.Settings
import com.developerxy.designsystem.theme.EchoJournalTheme
import com.developerxy.designsystem.theme.colorsScheme
import com.developerxy.designsystem.theme.typography

@Composable
fun DefaultAppBar(
    modifier: Modifier = Modifier,
    onClickSettings: () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.your_echo_journal),
                style = typography().headlineLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        actions = {
            IconButton(onClick = onClickSettings) {
                Icon(
                    modifier = Modifier
                        .requiredSize(48.dp)
                        .padding(10.dp),
                    imageVector = EchoJournalIcons.Settings,
                    contentDescription = stringResource(R.string.settings)
                )
            }
        }
    )
}

@Composable
fun BackEnabledAppBar(
    modifier: Modifier = Modifier,
    onClickSettings: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.your_echo_journal),
                style = typography().headlineLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            IconButton(onClick = onClickSettings) {
                Icon(
                    modifier = Modifier
                        .requiredSize(48.dp)
                        .padding(10.dp),
                    imageVector = EchoJournalIcons.ArrowBack,
                    contentDescription = stringResource(R.string.back)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultAppBarPreview(modifier: Modifier = Modifier) {
    EchoJournalTheme {
        DefaultAppBar(
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    0.0f to colorsScheme().bgGradientStart, 1f to colorsScheme().bgGradientEnd,
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BackEnabledAppBarPreview(modifier: Modifier = Modifier) {
    EchoJournalTheme {
        BackEnabledAppBar(
            modifier = Modifier.background(
                brush = Brush.verticalGradient(
                    0.0f to colorsScheme().bgGradientStart, 1f to colorsScheme().bgGradientEnd,
                )
            )
        )
    }
}