package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Sets up default configuration such as default plugins, kotlin sources, libraries dependencies,
 * and make sure that a **Component** module is placed in the right place.
 *
 * *Make sure to only define dependencies here that are gonna be used by all the Component modules.*
 */
open class ComponentModule : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.path.startsWith(":component:")) {
            error("Component modules must be in /component/ folder")
        }
        project.apply<MultiplatformPlugin>()
    }
}
