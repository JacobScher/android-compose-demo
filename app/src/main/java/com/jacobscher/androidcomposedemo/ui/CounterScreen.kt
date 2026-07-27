package com.jacobscher.androidcomposedemo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jacobscher.androidcomposedemo.CounterViewModel
import com.jacobscher.androidcomposedemo.ui.theme.AndroidComposeDemoTheme

@Composable
fun CounterScreen(
    viewModel: CounterViewModel,
    modifier: Modifier = Modifier
) {
    val count by viewModel.count.collectAsState()

    CounterContent(
        count = count,
        onIncrement = viewModel::increment,
        onDecrement = viewModel::decrement,
        onReset = viewModel::reset,
        modifier = modifier
    )
}

@Composable
fun CounterContent(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Compose Demo",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Count: $count",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.testTag("count_text")
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onDecrement,
                modifier = Modifier.testTag("decrement_button")
            ) {
                Text("-")
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = onIncrement,
                modifier = Modifier.testTag("increment_button")
            ) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onReset,
            modifier = Modifier.testTag("reset_button")
        ) {
            Text("Reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterContentPreview() {
    AndroidComposeDemoTheme {
        CounterContent(
            count = 5,
            onIncrement = {},
            onDecrement = {},
            onReset = {}
        )
    }
}
