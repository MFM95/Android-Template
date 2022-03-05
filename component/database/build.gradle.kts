import dsl.androidMain
import dsl.iosMain
import dsl.jvmMain

plugins {
    kotlin("multiplatform")
    id("com.squareup.sqldelight")
}

apply<plugin.AndroidComponentModule>()

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps.sqlDelight.runtime)
            }
        }
        androidMain {
            dependencies {
                implementation(Deps.sqlDelight.android)
            }
        }
        jvmMain {
            dependencies {
                implementation(Deps.sqlDelight.sqlite)
            }
        }
        iosMain {
            dependencies {
                implementation(Deps.sqlDelight.native)
            }
        }
    }
}

sqldelight {
    database("SupplierDatabase") {
        packageName = "com.template.supplier.database"
    }
}
