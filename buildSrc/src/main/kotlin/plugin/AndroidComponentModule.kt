package plugin

import dsl.kotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Sets up default configuration such as default plugins, kotlin sources, android configuration,
 * libraries dependencies, and make sure that a **Component** module is placed in the right place.
 *
 * *Make sure to only define dependencies here that are gonna be used by all the Component modules.*
 */
class AndroidComponentModule : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.path.startsWith(":component:")) {
            error("Component modules must be in /component/ folder")
        }
        project.apply<MultiplatformPlugin>()
        project.apply<AndroidMultiplatformPlugin>()
        project.configureKotlin()
    }

    private fun Project.configureKotlin() {
        kotlin {
            android()
        }
    }
}
