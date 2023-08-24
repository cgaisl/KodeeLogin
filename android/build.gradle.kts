@file:Suppress("UnstableApiUsage")


plugins {
    id("com.android.application")
    kotlin("android")
}

group = "at.cgaisl.android"
version = "1.0-SNAPSHOT"

 dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0-alpha04")
    debugImplementation("androidx.compose.ui:ui-tooling:1.5.0")
}

android {
    namespace = "at.cgaisl.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "at.cgaisl.android.kodeelogin"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.2"
    }
}
