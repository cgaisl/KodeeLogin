package at.cgaisl.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.readResourceBytes

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ResourceImage(
    resourceName: String,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter? = null
) {
    var image: ImageBitmap? by remember { mutableStateOf(null) }
    LaunchedEffect("") {
        image = readResourceBytes(resourceName).toImageBitmap()
    }


    if (image != null) {
        Image(
            bitmap = image!!,
            contentDescription = null,
            modifier = modifier,
            colorFilter = colorFilter,
            contentScale = ContentScale.Crop
        )
    }
}
