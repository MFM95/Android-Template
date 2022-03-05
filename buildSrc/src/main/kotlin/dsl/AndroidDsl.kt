@file:Suppress("UnstableApiUsage")

package dsl

import com.android.build.api.dsl.AndroidSourceSet
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal typealias AndroidSourceSets = NamedDomainObjectContainer<out AndroidSourceSet>

internal fun Project.androidApplication(block: BaseAppModuleExtension.() -> Unit) {
    extensions.getByType<BaseAppModuleExtension>().block()
}

internal fun Project.androidLibrary(block: LibraryExtension.() -> Unit) {
    extensions.getByType<LibraryExtension>().block()
}

internal fun AndroidSourceSets.main(block: AndroidSourceSet.() -> Unit = {}): AndroidSourceSet =
    getOrCreate("main").apply(block)

private fun AndroidSourceSets.getOrCreate(name: String): AndroidSourceSet = findByName(name) ?: create(name)
