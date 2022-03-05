package plugin

import Deps
import dsl.androidApplication
import dsl.implementation
import dsl.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationModule : Plugin<Project> {

    override fun apply(project: Project) {
        project.apply(plugin = "com.android.application")
        project.apply(plugin = "org.jetbrains.kotlin.android")
        project.configureAndroid()
        project.configureDependencies()
    }

    private fun Project.configureAndroid() {
        androidApplication {
            compileSdk = Deps.android.compileSdk

            defaultConfig {
                applicationId = "com.template.supplier"
                minSdk = Deps.android.minSdk
                targetSdk = Deps.android.targetSdk

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = Deps.androidx.compose.version
            }
        }
    }

    private fun Project.configureDependencies() {
        dependencies {
            implementation(Deps.kotlinx.coroutines.core)
            implementation(Deps.kodein.compose)
            implementation(Deps.google.material)
            implementation(Deps.androidx.compose.tooling)
            implementation(Deps.androidx.compose.runtime)
            implementation(Deps.androidx.compose.material)
            implementation(Deps.androidx.navigation.compose)
            implementation(Deps.androidx.splashscreen)
            implementation(Deps.androidx.work)
            implementation(Deps.google.accompanist.insets)
            implementation(Deps.google.accompanist.systemuicontroller)
            implementation(Deps.google.accompanist.viewPager)
            implementation(Deps.google.accompanist.viewPagerIndicators)

            testImplementation(Deps.kotlin.test)
            testImplementation(Deps.testing.mockk)
            testImplementation(Deps.multiplatformSettings.core)
            testImplementation(Deps.multiplatformSettings.test)
        }
    }
}
