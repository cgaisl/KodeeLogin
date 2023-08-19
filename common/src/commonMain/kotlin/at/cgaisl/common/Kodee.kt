package at.cgaisl.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import kotlin.random.Random

data class KodeeTransformation(
    val headRotationX: Float = 0f,
    val headRotationY: Float = 0f,
    val headRotationZ: Float = 0f,
    val faceRotationX: Float = 0f,
    val faceRotationY: Float = 0f,
    val faceRotationZ: Float = 0f,
    val faceTranslationY: Float = 0f,
    val faceTranslationX: Float = 0f,
    val armsTranslationX: Float = 0f,
    val armsRotationY: Float = 0f,
    val armLeftRotationZ: Float = 0f,
    val armLeftTranslationX: Float = 0f,
    val armLeftTranslationY: Float = 0f,
    val armRightRotationZ: Float = 0f,
    val armRightTranslationX: Float = 0f,
    val armRightTranslationY: Float = 0f,
    val isBlinking: Boolean = true,
)

@Composable
fun Kodee(
    transformation: KodeeTransformation,
    blinks: Boolean = false,
    armsInFront: Boolean = false,
) {
    val conversion = with(LocalDensity.current) {
        1.dp.toPx()
    }

    fun Int.px(): Dp {
        return (this / conversion).toInt().dp
    }

    var isCurrentlyBlinking by remember { mutableStateOf(false) }
    val eyeRotation by animateFloatAsState(
        targetValue = if (isCurrentlyBlinking) 90f else 0f,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        ),
        finishedListener = {
            isCurrentlyBlinking = false
        }
    )

    LaunchedEffect(blinks) {
        if (!blinks) return@LaunchedEffect

        while (true) {
            isCurrentlyBlinking = true
            delay((Random.nextInt(1, 10) * 1000L))
        }
    }

    Box {
        // Arms
        Row(
            modifier = Modifier.zIndex(
                if (armsInFront) {
                    1f
                } else {
                    0f
                }
            )
                .padding(top = 117.px(), start = 0.px())
                .graphicsLayer(
                    translationX = transformation.armsTranslationX,
                    rotationY = transformation.armsRotationY,
                )
        ) {
            ResourceImage(
                "arm_left.png",
                modifier = Modifier
                    .padding(top = 42.px())
                    .graphicsLayer(
                        rotationZ = transformation.armLeftRotationZ,
                        translationX = transformation.armLeftTranslationX,
                        translationY = transformation.armLeftTranslationY,
                    )
            )

            ResourceImage(
                "arm_right.png",
                modifier = Modifier
                    .padding(start = 271.px())
                    .graphicsLayer(
                        rotationZ = transformation.armRightRotationZ,
                        translationX = transformation.armRightTranslationX,
                        translationY = transformation.armRightTranslationY,
                    )
            )
        }


        // Legs
        ResourceImage(
            "legs.png",
            modifier = Modifier.padding(top = 247.px(), start = 262.px())

        )

        // Head
        ResourceImage(
            "head.png",
            modifier = Modifier
                .padding(top = 0.px(), start = 159.px())
                .graphicsLayer(
                    rotationX = transformation.headRotationX,
                    rotationY = transformation.headRotationY,
                    rotationZ = transformation.headRotationZ
                )

        )

        // Face
        Box(
            modifier = Modifier
                .padding(top = 131.px(), start = 223.px())
                .graphicsLayer(
                    rotationX = transformation.faceRotationX,
                    rotationY = transformation.faceRotationY,
                    rotationZ = transformation.faceRotationZ,
                    translationY = transformation.faceTranslationY,
                    translationX = transformation.faceTranslationX,
                )
        ) {
            ResourceImage(
                "eyes.png",
                Modifier.graphicsLayer(
                    rotationX = eyeRotation
                )
            )

            ResourceImage(
                "mouth.png",
                modifier = Modifier
                    .padding(top = 96.px(), start = 92.px())
            )
        }
    }
}
