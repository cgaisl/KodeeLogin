package at.cgaisl.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.uikit.OnFocusBehavior
import androidx.compose.ui.window.ComposeUIViewController



@Suppress("FunctionName", "unused")
fun KodeeLoginViewController(
    email: ComposeState<String>,
    password: ComposeState<String>,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLogin: () -> Unit = {}
) = ComposeUIViewController(
    configure = {
        this.onFocusBehavior = OnFocusBehavior.DoNothing
    }
) {
    MaterialTheme(typography = typography())  {
        KodeeLogin(
            email = email.state.value,
            password = password.state.value,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onLogin = onLogin
        )
    }
}