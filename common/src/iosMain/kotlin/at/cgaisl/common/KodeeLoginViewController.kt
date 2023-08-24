package at.cgaisl.common

import androidx.compose.ui.uikit.OnFocusBehavior
import androidx.compose.ui.window.ComposeUIViewController

@Suppress("FunctionName", "unused")
fun KodeeLoginViewController(
    email: ComposeState<String>,
    password: ComposeState<String>,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
) = ComposeUIViewController(
    configure = {
        this.onFocusBehavior = OnFocusBehavior.DoNothing
    }
) {
    KodeeLogin(
        email = email.state.value,
        password = password.state.value,
        onEmailChange = {
            onEmailChange(it)
        },
        onPasswordChange = {
            onPasswordChange(it)
        },
    )
}