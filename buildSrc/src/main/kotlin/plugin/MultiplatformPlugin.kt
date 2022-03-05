package plugin

import Deps
import dsl.commonMain
import dsl.commonTest
import dsl.iosMain
import dsl.iosSimulatorArm64Main
import dsl.iosSimulatorArm64Test
import dsl.iosTest
import dsl.jvmMain
import dsl.jvmTest
import dsl.kotlin
import dsl.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

/**
 * Sets up default configuration such as default plugins, kotlin sources, and libraries dependencies
 * to be used by any multiplatform module.
 */
internal open class MultiplatformPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.apply(plugin = "kotlin-multiplatform")
        project.configureMultiplatform()
    }

    private fun Project.configureMultiplatform() {
        kotlin {
            jvm()
            ios()
            iosSimulatorArm64()

            sourceSets {
                commonMain {
                    dependencies {
                        implementation(Deps.kotlinx.coroutines.core)
                        implementation(Deps.kodein.core)
                    }
                }
                commonTest {
                    dependencies {
                        implementation(Deps.kotlin.test)
                        implementation(Deps.kotlinx.coroutines.test)
                    }
                }
                jvmMain {
                    dependsOn(commonMain())
                    dependencies {
                    }
                }
                jvmTest {
                    dependsOn(commonTest())
                    dependencies {
                        implementation(Deps.testing.mockk)
                        implementation(Deps.testing.fixture)
                    }
                }
                iosMain {
                    dependsOn(commonMain())
                    dependencies {
                    }
                }
                iosTest {
                    dependsOn(commonTest())
                    dependencies {
                    }
                }
                iosSimulatorArm64Main {
                    dependsOn(iosMain())
                    dependencies {
                    }
                }
                iosSimulatorArm64Test {
                    dependsOn(iosTest())
                    dependencies {
                    }
                }
            }
        }
    }
}
