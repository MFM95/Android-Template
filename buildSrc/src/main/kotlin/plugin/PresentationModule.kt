package plugin

import dsl.commonMain
import dsl.kotlin
import dsl.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Sets up default configuration such as default plugins, kotlin sources, libraries dependencies,
 * and make sure that a **Presentation** module is placed in the right place.
 *
 * *Make sure to only define dependencies here that are gonna be used by all the Presentation modules.*
 */
class PresentationModule : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.path.startsWith(":presentation:")) {
            error("Feature modules must be in /presentation/ folder")
        }
        project.apply<MultiplatformPlugin>()
        project.apply<AndroidMultiplatformPlugin>()
        project.configureKotlin()
    }

    private fun Project.configureKotlin() {
        kotlin {
            sourceSets {
                commonMain {
                    dependencies {
                        implementation(project(":component:core"))
                        implementation(project(":component:presentation"))
                    }
                }
            }
        }
    }
}
