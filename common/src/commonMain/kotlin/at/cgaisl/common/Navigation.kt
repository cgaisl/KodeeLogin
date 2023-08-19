package at.cgaisl.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*

@Composable
fun Navigation() {
    var currentScreen by remember { mutableStateOf(Screens.Login) }


    Column {
        Row {
            Screens.entries.forEach { screen ->
                Button(onClick = { currentScreen = screen }) {
                    Text(screen.name)
                }
            }
        }

        Surface {
            when (currentScreen) {
                Screens.Playground -> KodeePlayground()
                Screens.Login -> KodeeLogin()
            }
        }
    }
}