package at.cgaisl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun Navigation() {
    var currentScreen by remember { mutableStateOf(Screens.Login) }

    Surface(modifier = Modifier.fillMaxSize()) {
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
                Screens.Login -> KodeeLoginScreen()
            }
        }
    }
}