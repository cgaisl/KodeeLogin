package at.cgaisl.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ApplicationScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState

@Composable
fun ApplicationScope.KodeeLoginDesktop() {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 1500.dp, height = 1000.dp)
    ) {
        MaterialTheme(typography = typography()) {
            Navigation()
        }
    }
}
