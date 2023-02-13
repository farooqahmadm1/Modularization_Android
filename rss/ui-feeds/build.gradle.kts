apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    "implementation"(project(":android-components"))
    "implementation"(project(":rss:domain"))
    "implementation"("io.coil-kt:coil-compose:2.2.0")
}