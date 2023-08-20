package at.cgaisl.common

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

private val defaultTypography = Typography()
private val fontFamily = FontFamily(
    font("font/Manrope-Regular.ttf", "Manrope-Regular", FontWeight.Normal, FontStyle.Normal),
    font("font/Manrope-Medium.ttf", "Manrope-Medium", FontWeight.Medium, FontStyle.Normal),
    font("font/Manrope-Bold.ttf", "Manrope-Bold", FontWeight.Bold, FontStyle.Normal),
    font("font/Manrope-ExtraBold.ttf", "Manrope-ExtraBold", FontWeight.ExtraBold, FontStyle.Normal),
    font("font/Manrope-SemiBold.ttf", "Manrope-SemiBold", FontWeight.SemiBold, FontStyle.Normal),
    font("font/Manrope-Light.ttf", "Manrope-Light", FontWeight.Light, FontStyle.Normal),
    font("font/Manrope-ExtraLight.ttf", "Manrope-ExtraLight", FontWeight.ExtraLight, FontStyle.Normal),
)


val typography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(fontFamily = fontFamily),
    displayMedium = defaultTypography.displayMedium.copy(fontFamily = fontFamily),
    displaySmall = defaultTypography.displaySmall.copy(fontFamily = fontFamily),

    headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = fontFamily),
    headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = fontFamily),
    headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = fontFamily),

    titleLarge = defaultTypography.titleLarge.copy(fontFamily = fontFamily),
    titleMedium = defaultTypography.titleMedium.copy(fontFamily = fontFamily),
    titleSmall = defaultTypography.titleSmall.copy(fontFamily = fontFamily),

    bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = fontFamily),
    bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = fontFamily),
    bodySmall = defaultTypography.bodySmall.copy(fontFamily = fontFamily),

    labelLarge = defaultTypography.labelLarge.copy(fontFamily = fontFamily),
    labelMedium = defaultTypography.labelMedium.copy(fontFamily = fontFamily),
    labelSmall = defaultTypography.labelSmall.copy(fontFamily = fontFamily)
)