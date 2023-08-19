package at.cgaisl.common

sealed class KodeeConfig(
    val transformation: KodeeTransformation = KodeeTransformation(),
    val blinks: Boolean = true,
    val armsInFront: Boolean = false,
) {
    object Idle : KodeeConfig()
    object PasswordInputShown : KodeeConfig(
        blinks = true,
        transformation = KodeeTransformation(
            armLeftTranslationX = 84f,
            armLeftRotationZ = 165f,
            armLeftTranslationY = 21f,
            armRightTranslationX = -101f,
            armRightTranslationY = 15f,
            armRightRotationZ = -150f,
        ),
        armsInFront = true
    )

    object PasswordInputHidden : KodeeConfig(
        blinks = false,
        transformation = KodeeTransformation(
            armLeftTranslationX = 84f,
            armLeftRotationZ = 158f,
            armRightTranslationX = -101f,
            armRightTranslationY = 15f,
            armRightRotationZ = -150f,
        ),
        armsInFront = true
    )

    class EmailInput(progress: Float) : KodeeConfig(
        transformation = KodeeTransformation(
            headRotationX = -20f,
            headRotationY = -20f + progress * 40f,
            headRotationZ = -30f + progress * 60f,
            faceRotationX = -30f,
            faceRotationY = -10f + progress * 20f,
            faceRotationZ = -30f + progress * 60f,
            faceTranslationY = if (progress <= 0.5f) {
                10f * (1f - 2f * progress)
            } else {
                10f * (2f * progress - 1f)
            },
            faceTranslationX = if (progress <= 0.5f) {
                20f * (1f - 2f * progress)
            } else {
                -20f * (2f * progress - 1f)
            },
            armsTranslationX = -(-30f + progress * 60f),
            armsRotationY = -20f + progress * 40f,
        ),
    )
}