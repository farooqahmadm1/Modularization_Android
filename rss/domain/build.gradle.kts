apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    "api"(project(":core"))
}