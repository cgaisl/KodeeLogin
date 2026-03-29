import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.kotlin.compose)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName.set("kodeeLogin")
        browser {
            commonWebpackConfig {
                outputFileName = "kodeeLogin.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static(project.rootDir.path)
                    static(project.rootDir.path + "/shared/")
                    static(project.rootDir.path + "/nonAndroidMain/")
                    static(project.rootDir.path + "/webApp/")
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.components.resources)
            }
        }
    }
}
