package at.cgaisl.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Kodee(modifier: Modifier = Modifier) {

    val conversion = with(LocalDensity.current) {
        1.dp.toPx()
    }

    fun Int.px(): Dp {
        return (this / conversion).toInt().dp
    }

    Box {
        ResourceImage(
            "arms_regular.png",
            modifier = Modifier.padding(top = 87.px(), start = 0.px())

        )
        ResourceImage(
            "legs.png",
            modifier = Modifier.padding(top = 247.px(), start = 262.px())

        )

        ResourceImage(
            "head.png",
            modifier = Modifier.padding(top = 0.px(), start = 159.px())

        )

        ResourceImage(
            "face.png",
            modifier = Modifier.padding(top = 131.px(), start = 223.px())

        )
    }
}