package plugin

import Deps
import dsl.commonMain
import dsl.commonTest
import dsl.kotlin
import dsl.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Sets up default configuration such as default plugins, kotlin sources, libraries dependencies,
 * and make sure that a **Data** module is placed in the right place.
 *
 * *Make sure to only define dependencies here that are gonna be used by all the Data modules.*
 */
class DataModule : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.path.startsWith(":data:")) {
            error("Data modules must be in /data/ folder")
        }
        project.apply<MultiplatformPlugin>()
        project.apply<AndroidMultiplatformPlugin>()
        project.apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
        project.configureKotlin()
    }

    private fun Project.configureKotlin() {
        kotlin {
            sourceSets {
                commonMain {
                    dependencies {
                        implementation(project(":component:core"))

                        implementation(Deps.kotlinx.serialization.json)
                        implementation(Deps.ktor.client.core)
                        implementation(Deps.multiplatformSettings.core)
                        implementation(Deps.sqlDelight.coroutines)
                    }
                }
                commonTest {
                    dependencies {
                        implementation(project(":component:testing"))
                    }
                }
            }
        }
    }
}
