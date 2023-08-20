package at.cgaisl.common

import androidx.compose.runtime.*
import androidx.compose.ui.window.ComposeUIViewController

@Suppress("unused")
class SwiftUIInputDelegate(
    val onEmailChange: (String) -> Unit,
    val onPasswordChange: (String) -> Unit,
)

@Suppress("FunctionName", "unused")
fun KodeeLoginViewController(
    initialEmail: String,
    initialPassword: String,
    updateSwiftUIEmail: (String) -> Unit,
    updateSwiftUIPassword: (String) -> Unit,
    configureInputDelegate: (SwiftUIInputDelegate) -> Unit,
) = ComposeUIViewController {

    var email by remember { mutableStateOf(initialEmail) }
    var password by remember { mutableStateOf(initialPassword) }

    LaunchedEffect(Unit) {
        configureInputDelegate(
            SwiftUIInputDelegate(
                onEmailChange = {
                    email = it
                },
                onPasswordChange = {
                    password = it
                },
            )
        )
    }

    KodeeLogin(
        email = email,
        password = password,
        onEmailChange = {
            email = it
            updateSwiftUIEmail(it)
        },
        onPasswordChange = {
            password = it
            updateSwiftUIPassword(it)
        },
    )
}