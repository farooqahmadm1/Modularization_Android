apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    "implementation"(project(Modules.rssDomain))
    "implementation"(Room.kotlin)
    "implementation"(Room.runtime)
    "implementation"(Room.guava)
    "kapt"(Room.compiler)
}