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

sealed class KodeeState(
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
) {
    object Idle : KodeeState()
    object PasswordInputShown : KodeeState(
        isBlinking = false,
        armsTranslationX = 00f
    )

    object PasswordInputHidden : KodeeState(
        isBlinking = false,
        armLeftTranslationX = 84f,
        armLeftRotationZ = 158f,
        armRightTranslationX = -101f,
        armRightTranslationY = 15f,
        armRightRotationZ = -150f,
    )

    class EmailInput(progress: Float) : KodeeState(
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
        armsTranslationX = -(-30f + progress * 60f),
        armsRotationY = -20f + progress * 40f,
    )
}

@Composable
fun Kodee(
    kodeeState: KodeeState,
    x: Float = 0f,
    y: Float = 0f,
    rot: Float = 0f,
) {
    val conversion = with(LocalDensity.current) {
        1.dp.toPx()
    }

    fun Int.px(): Dp {
        return (this / conversion).toInt().dp
    }

    var isBlinking by remember { mutableStateOf(false) }
    val eyeRotation by animateFloatAsState(
        targetValue = if (isBlinking) 90f else 0f,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        ),
        finishedListener = {
            isBlinking = false
        }
    )

    LaunchedEffect(kodeeState.isBlinking) {
        if (!kodeeState.isBlinking) return@LaunchedEffect

        while (true) {
            isBlinking = true
            delay((Random.nextInt(1, 10) * 1000L))
        }
    }

    Box {
        // Arms
        Row(
            modifier = Modifier.zIndex(
                when (kodeeState) {
                    KodeeState.PasswordInputHidden, KodeeState.PasswordInputShown -> 1f
                    is KodeeState.EmailInput, KodeeState.Idle -> 0f
                }
            )
                .padding(top = 117.px(), start = 0.px())
                .graphicsLayer(
                    translationX = kodeeState.armsTranslationX,
                    rotationY = kodeeState.armsRotationY,
                )
        ) {
            ResourceImage(
                "arm_left.png",
                modifier = Modifier
                    .padding(top = 42.px())
                    .graphicsLayer(
                        rotationZ = kodeeState.armLeftRotationZ,
                        translationX = kodeeState.armLeftTranslationX,
                        translationY = kodeeState.armLeftTranslationY,
                    )
            )

            ResourceImage(
                "arm_right.png",
                modifier = Modifier
                    .padding(start = 271.px())
                    .graphicsLayer(
                        rotationZ = kodeeState.armRightRotationZ,
                        translationX = kodeeState.armRightTranslationX,
                        translationY = kodeeState.armRightTranslationY,
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
                    rotationX = kodeeState.headRotationX,
                    rotationY = kodeeState.headRotationY,
                    rotationZ = kodeeState.headRotationZ
                )

        )

        // Face
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
