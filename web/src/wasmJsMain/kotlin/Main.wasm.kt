import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import at.cgaisl.common.KodeeLoginScreen
import kotlinx.browser.document

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.getElementById("kodeeLoginCanvas")!!) {
        MaterialTheme {
            KodeeLoginScreen()
        }
    }
}
