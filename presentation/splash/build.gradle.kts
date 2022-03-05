plugins {
    kotlin("multiplatform")
}

apply<plugin.PresentationModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain:auth"))
            }
        }
    }
}
