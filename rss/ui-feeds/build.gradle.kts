apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    "implementation"(project(":android-components"))
    "implementation"(project(Modules.rssDomain))
    "implementation"(project(":constants"))
    "implementation"(Coil.coilCompose)
}