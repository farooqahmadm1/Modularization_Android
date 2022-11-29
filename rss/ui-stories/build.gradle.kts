apply {
    from("$rootDir/android-library-build.gradle")
}


dependencies {
    "implementation"(project(Modules.components))
    "implementation"(project(Modules.rssDomain))
}