package at.cgaisl.common

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

private val defaultTypography = Typography()
private val fontFamily = FontFamily(
    Font(resource = "font/Manrope-Regular.ttf", FontWeight.Normal),
    Font(resource = "font/Manrope-Medium.ttf", FontWeight.Medium),
    Font(resource = "font/Manrope-Bold.ttf", FontWeight.Bold),
    Font(resource = "font/Manrope-ExtraBold.ttf", FontWeight.ExtraBold),
    Font(resource = "font/Manrope-SemiBold.ttf", FontWeight.SemiBold),
    Font(resource = "font/Manrope-Light.ttf", FontWeight.Light),
    Font(resource = "font/Manrope-ExtraLight.ttf", FontWeight.ExtraLight),
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