package at.cgaisl.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import at.cgaisl.common.resources.*
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
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
            delay((Random.nextInt(1, 10) * 1000L))
            isCurrentlyBlinking = true
        }
    }

    val animatedHeadRotationX by animateFloatAsState(transformation.headRotationX)
    val animatedHeadRotationY by animateFloatAsState(transformation.headRotationY)
    val animatedHeadRotationZ by animateFloatAsState(transformation.headRotationZ)
    val animatedFaceRotationX by animateFloatAsState(transformation.faceRotationX)
    val animatedFaceRotationY by animateFloatAsState(transformation.faceRotationY)
    val animatedFaceRotationZ by animateFloatAsState(transformation.faceRotationZ)
    val animatedFaceTranslationY by animateFloatAsState(transformation.faceTranslationY)
    val animatedFaceTranslationX by animateFloatAsState(transformation.faceTranslationX)
    val animatedArmsTranslationX by animateFloatAsState(transformation.armsTranslationX)
    val animatedArmsRotationY by animateFloatAsState(transformation.armsRotationY)
    val animatedArmLeftRotationZ by animateFloatAsState(transformation.armLeftRotationZ)
    val animatedArmLeftTranslationX by animateFloatAsState(transformation.armLeftTranslationX)
    val animatedArmLeftTranslationY by animateFloatAsState(transformation.armLeftTranslationY)
    val animatedArmRightRotationZ by animateFloatAsState(transformation.armRightRotationZ)
    val animatedArmRightTranslationX by animateFloatAsState(transformation.armRightTranslationX)
    val animatedArmRightTranslationY by animateFloatAsState(transformation.armRightTranslationY)

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
                    translationX = animatedArmsTranslationX,
                    rotationY = animatedArmsRotationY,
                )
        ) {
            Image(
                painter = painterResource(Res.drawable.arm_left),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 42.px())
                    .graphicsLayer(
                        rotationZ = animatedArmLeftRotationZ,
                        translationX = animatedArmLeftTranslationX,
                        translationY = animatedArmLeftTranslationY,
                    )
            )

            Image(
                painter = painterResource(Res.drawable.arm_right),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 271.px())
                    .graphicsLayer(
                        rotationZ = animatedArmRightRotationZ,
                        translationX = animatedArmRightTranslationX,
                        translationY = animatedArmRightTranslationY,
                    )
            )
        }


        // Legs
        Image(
            painter = painterResource(Res.drawable.legs),
            contentDescription = null,
            modifier = Modifier.padding(top = 247.px(), start = 262.px())

        )

        // Head
        Image(
            painter = painterResource(Res.drawable.head),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 0.px(), start = 159.px())
                .graphicsLayer(
                    rotationX = animatedHeadRotationX,
                    rotationY = animatedHeadRotationY,
                    rotationZ = animatedHeadRotationZ
                )

        )

        // Face
        Box(
            modifier = Modifier
                .padding(top = 131.px(), start = 223.px())
                .graphicsLayer(
                    rotationX = animatedFaceRotationX,
                    rotationY = animatedFaceRotationY,
                    rotationZ = animatedFaceRotationZ,
                    translationY = animatedFaceTranslationY,
                    translationX = animatedFaceTranslationX,
                )
        ) {
            Image(
                painter = painterResource(Res.drawable.eyes),
                contentDescription = null,
                Modifier.graphicsLayer(
                    rotationX = eyeRotation
                )
            )

            Image(
                painter = painterResource(Res.drawable.mouth),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 96.px(), start = 92.px())
            )
        }
    }
}
