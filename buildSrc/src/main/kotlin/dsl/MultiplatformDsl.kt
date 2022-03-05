package dsl

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

internal typealias KotlinSourceSets = NamedDomainObjectContainer<out KotlinSourceSet>

internal fun Project.kotlin(block: KotlinMultiplatformExtension.() -> Unit) {
    extensions.getByType<KotlinMultiplatformExtension>().block()
}

internal fun KotlinMultiplatformExtension.sourceSets(block: KotlinSourceSets.() -> Unit) {
    sourceSets.block()
}

// common

fun KotlinSourceSets.commonMain(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("commonMain").apply(block)

fun KotlinSourceSets.commonTest(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("commonTest").apply(block)

// jvm

fun KotlinSourceSets.jvmMain(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("jvmMain").apply(block)

fun KotlinSourceSets.jvmTest(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("jvmTest").apply(block)

// android

fun KotlinSourceSets.androidMain(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("androidMain").apply(block)

fun KotlinSourceSets.androidTest(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("androidTest").apply(block)

// ios

fun KotlinSourceSets.iosMain(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("iosMain").apply(block)

fun KotlinSourceSets.iosTest(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("iosTest").apply(block)

// iosSimulatorArm64

fun KotlinSourceSets.iosSimulatorArm64Main(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("iosSimulatorArm64Main").apply(block)

fun KotlinSourceSets.iosSimulatorArm64Test(block: KotlinSourceSet.() -> Unit = {}): KotlinSourceSet =
    getOrCreate("iosSimulatorArm64Test").apply(block)

private fun KotlinSourceSets.getOrCreate(name: String): KotlinSourceSet = findByName(name) ?: create(name)
