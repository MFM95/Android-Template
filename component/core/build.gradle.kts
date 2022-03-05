plugins {
    kotlin("multiplatform")
}

apply<plugin.ComponentModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
            }
        }
    }
}
