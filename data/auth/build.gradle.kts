plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

apply<plugin.DataModule>()


kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":component:api-contract"))
                implementation(project(":component:database"))
                implementation(project(":domain:auth"))
            }
        }
    }
}
