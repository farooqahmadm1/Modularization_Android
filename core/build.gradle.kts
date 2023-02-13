apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    /**
     * retrofit + okhttp3
     */
    "api"("com.squareup.retrofit2:retrofit:2.9.0")
    "api"("com.squareup.retrofit2:converter-gson:2.9.0")
    "api"("com.squareup.retrofit2:converter-simplexml:2.9.0")

    "api"(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    "api"("com.squareup.okhttp3:okhttp")
    "api"("com.squareup.okhttp3:logging-interceptor")

    val navigationVersion = "2.5.2"
    /**
     * Navigation
     */
    "api"("androidx.navigation:navigation-fragment-ktx:$navigationVersion")
    "api"("androidx.navigation:navigation-ui-ktx:$navigationVersion")
    val paging_version = "3.1.1"
    "api"("androidx.paging:paging-runtime:$paging_version")
    "api"("androidx.paging:paging-common:$paging_version")
}