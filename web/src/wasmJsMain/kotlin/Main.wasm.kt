import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import at.cgaisl.common.KodeeLoginScreen

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("KodeeLogin", canvasElementId = "kodeeLoginCanvas") {
        MaterialTheme {
            KodeeLoginScreen()
        }
    }
}
