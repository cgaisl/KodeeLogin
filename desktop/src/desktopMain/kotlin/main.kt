import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import at.cgaisl.common.KodeeLoginDesktop
import at.cgaisl.common.KodeeLoginScreen
import at.cgaisl.common.Navigation
import at.cgaisl.common.typography

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 1500.dp, height = 1000.dp)
    ) {
        MaterialTheme(typography = typography()) {
            KodeeLoginScreen()
        }
    }
}
