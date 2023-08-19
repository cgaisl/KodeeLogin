package at.cgaisl.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun EmailInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isFocused: Boolean = false,
    onFocused: () -> Unit = {},
) {
    Column {
        Text(
            "Email",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
        )

        KodeeInputField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            isFocused = isFocused,
            onFocussed = onFocused,
        )
    }
}


@Composable
fun PasswordInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    showPassword: Boolean = true,
    setPasswordShown: (Boolean) -> Unit = {},
    isFocused: Boolean = false,
    onFocused: () -> Unit = {}
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Password",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = showPassword,
                    onCheckedChange = { setPasswordShown(!showPassword) }
                )

                Text("Show Password")
            }
        }

        KodeeInputField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            isFocused = isFocused,
            onFocussed = onFocused,
            hideInput = !showPassword
        )
    }
}

@Composable
fun KodeeInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isFocused: Boolean = false,
    onFocussed: () -> Unit = {},
    hideInput: Boolean = false,
) {
    val focusRequester = FocusRequester()

    LaunchedEffect(isFocused) {
        if (isFocused) {
            focusRequester.requestFocus()
        }
    }

    val textFieldBorderColor =
        if (isFocused)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.onSurfaceVariant

    val shadowElevation = if (isFocused) 4.dp else 0.dp

    BasicTextField(
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = Password),
        visualTransformation = if (hideInput) PasswordVisualTransformation() else VisualTransformation.None,
        textStyle = MaterialTheme.typography.bodyLarge,
        modifier = modifier
            .shadow(
                shadowElevation,
                shape = RoundedCornerShape(4.dp),
                ambientColor = textFieldBorderColor,
                spotColor = textFieldBorderColor
            )
            .background(Color.White)
            .onFocusChanged {
                if (it.isFocused) {
                    onFocussed()
                }
            }
            .focusRequester(focusRequester),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .border(
                        2.dp,
                        textFieldBorderColor,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(8.dp)
                    .fillMaxWidth()

            ) {
                innerTextField()
            }
        },
    )
}