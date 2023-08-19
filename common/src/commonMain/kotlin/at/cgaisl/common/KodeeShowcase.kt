package at.cgaisl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import at.cgaisl.common.screens.login.KodeeState

@Composable
fun KodeeShowcase() {
    var progress by remember { mutableStateOf(0f) }
    val kodeeStates = listOf(
        KodeeState.EmailInput(progress),
        KodeeState.Idle,
        KodeeState.PasswordInputHidden,
        KodeeState.PasswordInputShown,
    )

    Column{
        Column {
            Text("Progress: $progress")

            Slider(
                value = progress,
                onValueChange = { newValue ->
                    progress = newValue
                },
                valueRange = (0f..1f),
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(kodeeStates) {
                Row {
                    when (it) {
                        is KodeeState.EmailInput -> Text("Email Input")
                        KodeeState.Idle -> Text("Idle")
                        KodeeState.PasswordInputHidden -> Text("PasswordInputHidden")
                        KodeeState.PasswordInputShown -> Text("PasswordInputShown")
                    }

                    Kodee(
                        transformation = it.transformation,
                        blinks = it.isBlinking,
                        armsInFront = it.armsInFront,
                    )
                }
            }
        }

        Row {
            Text("Email Input:")


            Kodee(
                transformation = KodeeState.EmailInput(progress).transformation
            )
        }

        Row {
            Text("Password Input Hidden:")

            Kodee(
                transformation = KodeeState.PasswordInputHidden.transformation
            )
        }
    }
}