pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Template"

include(":android")

include(":component:core")
include(":component:testing")
include(":component:presentation")
include(":component:api-contract", ":component:api")
include(":component:database")
include(":data:auth")
include(":domain")
include(":domain:auth")
include(":presentation")
include(":presentation:splash")
include(":presentation:onboarding")
include(":presentation:signin")
