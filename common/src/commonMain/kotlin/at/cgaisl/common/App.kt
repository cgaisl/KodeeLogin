package at.cgaisl.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
internal fun App() {
    MaterialTheme(typography = typography()) {
        Navigation()
    }
}