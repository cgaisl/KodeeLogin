package at.cgaisl.common

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kotlin.math.min

private enum class InputField {
    Email,
    Password
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun KodeeLogin(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit
) {
    var focused by remember { mutableStateOf<InputField?>(null) }
    var showPassword by remember { mutableStateOf(false) }
    val (first, second) = remember { FocusRequester.createRefs() }
    val kodeeConfig = when (focused) {
        InputField.Email -> KodeeConfig.EmailInput(min(email.length / 30f, 1f))
        InputField.Password -> when (showPassword) {
            true -> KodeeConfig.PasswordInputShown
            false -> KodeeConfig.PasswordInputHidden
        }

        null -> KodeeConfig.Idle
    }
    val focusManager = LocalFocusManager.current

    LaunchedEffect(focused) {
        if (focused == null) {
            focusManager.clearFocus()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .noRippleClickable { focused = null },
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier
                .width(430.dp)
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Kodee(
                    transformation = kodeeConfig.transformation,
                    blinks = kodeeConfig.blinks,
                    armsInFront = kodeeConfig.armsInFront
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            EmailInputField(
                modifier = Modifier
                    .focusRequester(first)
                    .focusProperties {
                        next = second
                    },
                value = email,
                onValueChange = { onEmailChange(it) },
                isFocused = focused == InputField.Email,
                onFocused = {
                    focused = InputField.Email
                }
            )

            PasswordInputField(
                modifier = Modifier
                    .focusRequester(second),
                value = password,
                onValueChange = { onPasswordChange(it) },
                isFocused = focused == InputField.Password,
                onFocused = {
                    focused = InputField.Password
                },
                showPassword = showPassword,
                setPasswordShown = {
                    showPassword = it
                    focused = InputField.Password
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    focused = null
                    onLogin()
                }
            ) {
                Text("Login")
            }
        }
    }
}