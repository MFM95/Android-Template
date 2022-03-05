plugins {
    kotlin("multiplatform")
}
apply<plugin.DomainModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
            }
        }
    }
}
