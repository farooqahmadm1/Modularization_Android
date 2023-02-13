apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    "implementation"(project(":rss:domain"))
    val room_version = "2.4.3"
    "implementation"("androidx.room:room-ktx:$room_version")
    "implementation"("androidx.room:room-runtime:$room_version")
    "implementation"("androidx.room:room-guava:$room_version")
    "kapt"("androidx.room:room-compiler:$room_version")
}