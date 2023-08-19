package at.cgaisl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*


@Composable
internal fun App() {
    var currentScreen by remember { mutableStateOf(Screens.Playground) }

    Column {
        Row {
            Screens.entries.forEach { screen ->
                Button(onClick = { currentScreen = screen }) {
                    Text(screen.name)
                }
            }
        }

        when (currentScreen) {
            Screens.Playground -> KodeePlayground()
            Screens.Login -> TODO()
        }
    }
}