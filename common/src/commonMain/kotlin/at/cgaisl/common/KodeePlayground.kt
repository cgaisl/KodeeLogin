package at.cgaisl.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun KodeePlayground() {
    var transformation by remember { mutableStateOf(KodeeTransformation()) }
    var blinks by remember { mutableStateOf(true) }
    var armsInFront by remember { mutableStateOf(false) }

    fun setToKodeeState(state: KodeeConfig) {
        transformation = state.transformation
        blinks = state.blinks
        armsInFront = state.armsInFront
    }


    Row {
        Column {
            Kodee(
                transformation = transformation,
                blinks = blinks,
                armsInFront = armsInFront,
            )

            Button(onClick = { blinks = !blinks }) {
                Text("Toggle Blinks: $blinks", color = Color.White)
            }

            Button(onClick = { armsInFront = !armsInFront }) {
                Text("Toggle Arms in Front: $armsInFront", color = Color.White)
            }

            Button(onClick = { transformation = KodeeTransformation() }) {
                Text("Reset", color = Color.White)
            }

            SliderBox {
                var progress by remember { mutableStateOf(0f) }

                Text("Email-Input")

                Slider(
                    value = progress,
                    onValueChange = {
                        progress = it
                        setToKodeeState(KodeeConfig.EmailInput(it))
                    },
                    valueRange = (0f..1f),
                )
            }

            Button(onClick = { setToKodeeState(KodeeConfig.Idle) }) {
                Text("Idle", color = Color.White)
            }

            Button(onClick = { setToKodeeState(KodeeConfig.PasswordInputHidden) }) {
                Text("Password-Input-Hidden", color = Color.White)
            }

            Button(onClick = { setToKodeeState(KodeeConfig.PasswordInputShown) }) {
                Text("Password-Input-Shown", color = Color.White)
            }
        }

        Column {
            SliderBox {
                Text("Head Rotation X: ${transformation.headRotationX}")

                Slider(
                    value = transformation.headRotationX,
                    onValueChange = { transformation = transformation.copy(headRotationX = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Head Rotation Y: ${transformation.headRotationY}")

                Slider(
                    value = transformation.headRotationY,
                    onValueChange = { transformation = transformation.copy(headRotationY = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Head Rotation Z: ${transformation.headRotationZ}")

                Slider(
                    value = transformation.headRotationZ,
                    onValueChange = { transformation = transformation.copy(headRotationZ = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Face Rotation X: ${transformation.faceRotationX}")

                Slider(
                    value = transformation.faceRotationX,
                    onValueChange = { transformation = transformation.copy(faceRotationX = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Face Rotation Y: ${transformation.faceRotationY}")

                Slider(
                    value = transformation.faceRotationY,
                    onValueChange = { transformation = transformation.copy(faceRotationY = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Face Rotation Z: ${transformation.faceRotationZ}")

                Slider(
                    value = transformation.faceRotationZ,
                    onValueChange = { transformation = transformation.copy(faceRotationZ = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Face Translation X: ${transformation.faceTranslationX}")

                Slider(
                    value = transformation.faceTranslationX,
                    onValueChange = { transformation = transformation.copy(faceTranslationX = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Face Translation Y: ${transformation.faceTranslationY}")

                Slider(
                    value = transformation.faceTranslationY,
                    onValueChange = { transformation = transformation.copy(faceTranslationY = it) },
                    valueRange = (-300f..300f),
                )
            }
        }

        Column {
            SliderBox {
                Text("Arms Rotation Y: ${transformation.armsRotationY}")

                Slider(
                    value = transformation.armsRotationY,
                    onValueChange = { transformation = transformation.copy(armsRotationY = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arms Translation X: ${transformation.armsTranslationX}")

                Slider(
                    value = transformation.armsTranslationX,
                    onValueChange = { transformation = transformation.copy(armsTranslationX = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arm Left Rotation Z: ${transformation.armLeftRotationZ}")

                Slider(
                    value = transformation.armLeftRotationZ,
                    onValueChange = { transformation = transformation.copy(armLeftRotationZ = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arm Left Translation X: ${transformation.armLeftTranslationX}")

                Slider(
                    value = transformation.armLeftTranslationX,
                    onValueChange = { transformation = transformation.copy(armLeftTranslationX = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arm Left Translation Y: ${transformation.armLeftTranslationY}")

                Slider(
                    value = transformation.armLeftTranslationY,
                    onValueChange = { transformation = transformation.copy(armLeftTranslationY = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arm Right Rotation Z: ${transformation.armRightRotationZ}")

                Slider(
                    value = transformation.armRightRotationZ,
                    onValueChange = { transformation = transformation.copy(armRightRotationZ = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arm Right Translation X: ${transformation.armRightTranslationX}")

                Slider(
                    value = transformation.armRightTranslationX,
                    onValueChange = { transformation = transformation.copy(armRightTranslationX = it) },
                    valueRange = (-300f..300f),
                )
            }

            SliderBox {
                Text("Arm Right Translation Y: ${transformation.armRightTranslationY}")

                Slider(
                    value = transformation.armRightTranslationY,
                    onValueChange = { transformation = transformation.copy(armRightTranslationY = it) },
                    valueRange = (-300f..300f),
                )
            }


        }
    }
}

@Composable
private fun SliderBox(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier
            .border(1.dp, Color.Black)
            .width(250.dp),
        content = content,
    )
}