import dsl.androidMain
import dsl.iosMain
import dsl.jvmMain

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

apply<plugin.AndroidComponentModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":component:core"))
                implementation(project(":component:api-contract"))

                implementation(Deps.ktor.client.core)
                implementation(Deps.ktor.client.serialization)
                implementation(Deps.ktor.client.logging)
           }
        }
        androidMain {
            dependencies {
                implementation(Deps.ktor.client.android)
            }
        }
        jvmMain {
            dependencies {
                implementation(Deps.ktor.client.jvm)
            }
        }
        iosMain {
            dependencies {
                implementation(Deps.ktor.client.ios)
            }
        }
    }
}
