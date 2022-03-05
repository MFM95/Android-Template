package plugin

import Deps
import dsl.androidLibrary
import dsl.androidMain
import dsl.androidTest
import dsl.commonMain
import dsl.commonTest
import dsl.kotlin
import dsl.main
import dsl.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Sets up default configuration such as default plugins, kotlin sources, android configuration,
 * and libraries dependencies to be used by any multiplatform android module.
 */
internal class AndroidMultiplatformPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.apply(plugin = "com.android.library")
        project.configureMultiplatform()
        project.configureAndroid()
    }

    private fun Project.configureMultiplatform() {
        kotlin {
            android()

            sourceSets {
                androidMain {
                    dependsOn(commonMain())
                    dependencies {
                    }
                }
                androidTest {
                    dependsOn(commonTest())
                    dependencies {
                    }
                }
            }
        }
    }

    private fun Project.configureAndroid() {
        androidLibrary {
            compileSdk = Deps.android.compileSdk

            defaultConfig {
                minSdk = Deps.android.minSdk
                targetSdk = Deps.android.targetSdk

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            sourceSets {
                main {
                    manifest.srcFile("src/androidMain/AndroidManifest.xml")
                }
            }

            buildTypes {
                release {
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    isMinifyEnabled = true
                }
                debug {
                    isMinifyEnabled = false
                }
            }
        }
    }
}
