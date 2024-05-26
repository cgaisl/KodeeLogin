package at.cgaisl.common

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import at.cgaisl.common.resources.Res
import at.cgaisl.common.resources.manrope
import org.jetbrains.compose.resources.Font

@SuppressLint("DiscouragedApi")
@Composable
actual fun font(res: String, weight: FontWeight, style: FontStyle): Font = Font(
    Res.font.manrope,
    weight,
    style
)
