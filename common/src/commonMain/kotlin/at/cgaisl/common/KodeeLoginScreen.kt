package at.cgaisl.common

import androidx.compose.runtime.*

@Composable
fun KodeeLoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    KodeeLogin(
        email = email,
        password = password,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onLogin = {}
    )
}