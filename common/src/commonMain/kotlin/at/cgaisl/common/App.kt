package at.cgaisl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*


@Composable
internal fun App() {
    var progress by remember { mutableStateOf(0f) }

    Column {

        Kodee(
            kodeeState = KodeeState.EmailInput(progress = progress)
        )

        Slider(
            value = progress,
            onValueChange = { newValue ->
                progress = newValue
            },
            valueRange = (0f.. 1f),
        )

        Text("progress Slider Value: $progress")
    }
}