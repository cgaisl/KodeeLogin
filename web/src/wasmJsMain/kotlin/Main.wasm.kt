import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import at.cgaisl.common.KodeeLoginScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.configureWebResources
import org.jetbrains.compose.resources.urlResource

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    configureWebResources{
        setResourceFactory { urlResource("./$it") }
    }
    CanvasBasedWindow("KodeeLogin", canvasElementId = "kodeeLoginCanvas") {
        MaterialTheme {
            KodeeLoginScreen()
        }
    }
}
