@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

val copyWasmResources = tasks.create("copyWasmResourcesWorkaround", Copy::class.java) {
    from(project(":common").file("src/commonMain/resources"))
    into("build/processedResources/wasmJs/main")

    doLast {
        println("This really works")
    }
}

afterEvaluate {
    project.tasks.named("wasmJsDevelopmentExecutableCompileSync") {
        mustRunAfter("copyWasmResourcesWorkaround")
    }
    project.tasks.getByName("wasmJsProcessResources").finalizedBy(copyWasmResources)
}

kotlin {
    wasmJs {
        moduleName = "kodeeLogin"
        browser {
            commonWebpackConfig {
                outputFileName = "kodeeLogin.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(project.rootDir.path)
                        add(project.rootDir.path + "/shared/")
                        add(project.rootDir.path + "/nonAndroidMain/")
                        add(project.rootDir.path + "/webApp/")
                    }
                }
            }
        }
        binaries.executable()
    }


    sourceSets {
        @OptIn(ExperimentalComposeLibrary::class)
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

compose.experimental {
    web.application {}
}
