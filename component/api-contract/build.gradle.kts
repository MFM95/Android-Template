plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

apply<plugin.ComponentModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps.ktor.client.serialization)
            }
        }
    }
}
