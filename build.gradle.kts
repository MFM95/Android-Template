buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.kotlin.plugin)
        classpath(Deps.kotlinx.serialization.plugin)
        classpath(Deps.android.plugin)
        classpath(Deps.sqlDelight.plugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
