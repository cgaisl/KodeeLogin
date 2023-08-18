plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    application
}

dependencies {
    implementation(project(":common"))
    implementation(compose.desktop.currentOs)
}

application {
    mainClass.set("MainKt")
}
