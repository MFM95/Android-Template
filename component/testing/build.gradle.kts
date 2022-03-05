plugins {
    kotlin("multiplatform")
}

apply<plugin.ComponentModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":component:core"))

                implementation(Deps.kotlinx.coroutines.test)
            }
        }
    }
}
