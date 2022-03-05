plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    implementation(Deps.kotlin.plugin)
    implementation(Deps.android.plugin)
}

kotlin {
    /** Add [Deps] to the source sets, so it will become also available in this project */
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}
