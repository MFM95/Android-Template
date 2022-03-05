plugins {
    id("com.android.application")
}
apply<plugin.AndroidApplicationModule>()

dependencies {
    implementation(project(":component:core"))
    implementation(project(":component:presentation"))
    implementation(project(":component:api-contract"))
    implementation(project(":component:api"))
    implementation(project(":component:database"))

    // Auth
    implementation(project(":domain:auth"))
    implementation(project(":data:auth"))

    // Splash
    implementation(project(":presentation:splash"))

    // OnBoarding
    implementation(project(":presentation:onboarding"))

    // SignIn
    implementation(project(":presentation:signin"))


}