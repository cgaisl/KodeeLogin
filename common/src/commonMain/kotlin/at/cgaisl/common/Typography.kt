package at.cgaisl.common

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

private val defaultTypography = Typography()

@Composable
private fun fontFamily() = FontFamily(
    font("manrope_regular", FontWeight.Normal, FontStyle.Normal),
    font("manrope_medium", FontWeight.Medium, FontStyle.Normal),
    font("manrope_bold", FontWeight.Bold, FontStyle.Normal),
    font("manrope_extra_bold", FontWeight.ExtraBold, FontStyle.Normal),
    font("manrope_semi_bold", FontWeight.SemiBold, FontStyle.Normal),
    font("manrope_light", FontWeight.Light, FontStyle.Normal),
    font("manrope_extra_light", FontWeight.ExtraLight, FontStyle.Normal),
)

@Composable
fun typography() = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = fontFamily()),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = fontFamily()),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = fontFamily()),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = fontFamily()),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = fontFamily()),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = fontFamily()),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = fontFamily()),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = fontFamily()),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = fontFamily()),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = fontFamily()),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = fontFamily()),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = fontFamily()),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = fontFamily()),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = fontFamily()),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = fontFamily())
)