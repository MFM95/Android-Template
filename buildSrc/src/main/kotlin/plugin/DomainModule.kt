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
 * and make sure that a **Domain** module is placed in the right place.
 *
 * *Make sure to only define dependencies here that are gonna be used by all the Domain modules.*
 */
class DomainModule : Plugin<Project> {

    override fun apply(project: Project) {
        if (!project.path.startsWith(":domain:")) {
            error("Domain modules must be in /domain/ folder")
        }
        project.apply<MultiplatformPlugin>()
        project.configureKotlin()
    }

    private fun Project.configureKotlin() {
        kotlin {
            sourceSets {
                commonMain {
                    dependencies {
                        implementation(project(":component:core"))

                        implementation(Deps.kotlinx.coroutines.core)
                        implementation(Deps.kodein.core)
                    }
                }
                commonTest {
                    dependencies {
                        implementation(project(":component:testing"))

                        implementation(Deps.kotlin.test)
                        implementation(Deps.kotlinx.coroutines.test)
                    }
                }
            }
        }
    }
}
