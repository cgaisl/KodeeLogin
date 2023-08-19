package at.cgaisl.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


sealed class KodeeState(
    val headRotationX: Float = 0f,
    val headRotationY: Float = 0f,
    val headRotationZ: Float = 0f,
    val faceRotationX: Float = 0f,
    val faceRotationY: Float = 0f,
    val faceRotationZ: Float = 0f,
    val faceTranslationY: Float = 0f,
    val faceTranslationX: Float = 0f,
) {
    object Idle : KodeeState()
    object PasswordInputShown : KodeeState()
    object PasswordInputHidden : KodeeState()
    data class EmailInput(val progress: Float) : KodeeState(
        headRotationX = -20f,
        headRotationY = -20f + progress * 40f,
        headRotationZ = -30f + progress * 60f,
        faceRotationX = -30f,
        faceRotationY = -10f + progress * 20f,
        faceRotationZ = -30f + progress * 60f,
        faceTranslationY = if (progress <= 0.5f) {
            10f * (1f - 2f * progress)
        } else {
            10f * (2f * progress - 1f)
        },
        faceTranslationX = if (progress <= 0.5f) {
            20f * (1f - 2f * progress)
        } else {
            -20f * (2f * progress - 1f)
        },
    )
}

@Composable
fun Kodee(
    kodeeState: KodeeState,
) {
    val conversion = with(LocalDensity.current) {
        1.dp.toPx()
    }


    fun Int.px(): Dp {
        return (this / conversion).toInt().dp
    }



    Box {
        ResourceImage(
            "arms_regular.png",
            modifier = Modifier
                .padding(top = 87.px(), start = 0.px())
                .graphicsLayer(
                    translationX = -kodeeState.headRotationZ,
                    rotationY = kodeeState.headRotationY / 3
                )

        )
        ResourceImage(
            "legs.png",
            modifier = Modifier.padding(top = 247.px(), start = 262.px())

        )

        ResourceImage(
            "head.png",
            modifier = Modifier
                .padding(top = 0.px(), start = 159.px())
                .graphicsLayer(
                    rotationX = kodeeState.headRotationX,
                    rotationY = kodeeState.headRotationY,
                    rotationZ = kodeeState.headRotationZ
                )

        )

        Box(
            modifier = Modifier
                .padding(top = 131.px(), start = 223.px())
                .graphicsLayer(
                    rotationX = kodeeState.faceRotationX,
                    rotationY = kodeeState.faceRotationY,
                    rotationZ = kodeeState.faceRotationZ,
                    translationY = kodeeState.faceTranslationY,
                    translationX = kodeeState.faceTranslationX,
                )
        ) {
            ResourceImage(
                "eyes.png",
            )

            ResourceImage(
                "mouth.png",
                modifier = Modifier
                    .padding(top = 96.px(), start = 92.px())
            )
        }
    }
}