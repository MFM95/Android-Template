object Deps {
    private const val kotlinVersion = "1.6.10"

    val kotlin = Kotlin
    val kotlinx = Kotlinx
    val android = Android
    val androidx = Androidx
    val google = Google
    val ktor = Ktor
    val multiplatformSettings = MultiplatformSettings
    val kodein = Kodein
    val testing = Testing
    val sqlDelight = SqlDelight

    object Testing {
        const val mockk = "io.mockk:mockk:1.12.2"
        const val fixture = "com.appmattus.fixture:fixture:1.2.0"
    }

    object Kotlin {
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val test = "org.jetbrains.kotlin:kotlin-test:$kotlinVersion"
    }

    object Kotlinx {
        val coroutines = Coroutines
        val serialization = Serialization

        object Coroutines {
            private const val version = "1.6.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }

        object Serialization {
            private const val version = "1.3.2"
            const val plugin = "org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion"
            const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:$version"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }
    }

    object Android {
        const val compileSdk = 31
        const val minSdk = 21
        const val targetSdk = 31
        const val plugin = "com.android.tools.build:gradle:7.0.4"
    }

    object Androidx {
        val compose = Compose
        val navigation = Navigation
        const val splashscreen = "androidx.core:core-splashscreen:1.0.0-beta01"
        const val work = "androidx.work:work-runtime-ktx:2.7.1"

        object Compose {
            const val version = "1.1.0"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            val material = Material()

            class Material internal constructor(
                private val name: String = "androidx.compose.material:material:$version"
            ) : CharSequence by name {
                override fun toString() = name
            }
        }

        object Navigation {
            const val compose = "androidx.navigation:navigation-compose:2.4.0"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.5.0"
        val accompanist = Accompanist

        object Accompanist {
            private const val version = "0.15.0"
            const val insets = "com.google.accompanist:accompanist-insets:$version"
            const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:$version"
            const val viewPager = "com.google.accompanist:accompanist-pager:$version"
            const val viewPagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"

        }
    }

    object Ktor {
        val client = Client

        object Client {
            private const val version = "1.6.7"
            const val core = "io.ktor:ktor-client-core:$version"
            const val android = "io.ktor:ktor-client-android:$version"
            const val jvm = "io.ktor:ktor-client-java:$version"
            const val ios = "io.ktor:ktor-client-ios:$version"

            val serialization = Serialization()
            val logging = Logging()

            class Serialization internal constructor(
                private val name: String = "io.ktor:ktor-client-serialization:$version"
            ) : CharSequence by name {
                override fun toString() = name
            }

            class Logging internal constructor(
                private val name: String = "io.ktor:ktor-client-logging:$version"
            ) : CharSequence by name {
                val android = "io.ktor:ktor-client-logging-android:$version"
                val ios = "io.ktor:ktor-client-logging-ios:$version"
                override fun toString() = name
            }
        }
    }

    object MultiplatformSettings {
        private const val version = "0.8.1"
        const val core = "com.russhwolf:multiplatform-settings-no-arg:$version"
        const val test = "com.russhwolf:multiplatform-settings-test:$version"
    }

    object Kodein {
        private const val version = "7.10.0"
        const val core = "org.kodein.di:kodein-di:$version"
        const val android = "org.kodein.di:kodein-di-framework-android-core:$version"
        const val compose = "org.kodein.di:kodein-di-framework-compose:$version"
    }

    object SqlDelight {
        private const val version = "1.5.3"
        const val plugin = "com.squareup.sqldelight:gradle-plugin:$version"
        const val runtime = "com.squareup.sqldelight:runtime:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val native = "com.squareup.sqldelight:native-driver:$version"
        const val sqlite = "com.squareup.sqldelight:sqlite-driver:$version"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:$version"
    }

}
