package at.cgaisl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*


@Composable
internal fun App() {
    var progress by remember { mutableStateOf(0f) }
    var x by remember { mutableStateOf(0f) }
    var y by remember { mutableStateOf(0f) }
    var rot by remember { mutableStateOf(0f) }

    Column {

        Kodee(
            kodeeState = KodeeState.EmailInput(progress = progress)
        )

        Kodee(
            kodeeState = KodeeState.PasswordInputHidden, x, y, rot
        )

        Slider(
            value = progress,
            onValueChange = { newValue ->
                progress = newValue
            },
            valueRange = (0f.. 1f),
        )

        Slider(
            value = x,
            onValueChange = { newValue ->
                x = newValue
            },
            valueRange = (-500f.. 0f),
        )

        Text("x Slider Value: $x")

        Slider(
            value = y,
            onValueChange = { newValue ->
                y = newValue
            },
            valueRange = (0f.. 500f),
        )

        Text("y Slider Value: $y")

        Slider(
            value = rot,
            onValueChange = { newValue ->
                rot = newValue
            },
            valueRange = (-500f.. 0f),
        )

        Text("rot Slider Value: $rot")

        Text("progress Slider Value: $progress")

    }
}