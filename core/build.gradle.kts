apply {
    from("$rootDir/android-library-build.gradle")
}
dependencies {
    /**
     * retrofit + okhttp3
     */
    "api"(Retrofit.retrofit)
    "api"(Retrofit.gsonConverter)
    "api"(Retrofit.simpleXml)

    "api"(platform(OkHttp3.BOM))
    "api"(OkHttp3.okhttp)
    "api"(OkHttp3.logger)


    /**
     * Navigation
     */
    "api"(Navigation.navigationFragment)
    "api"(Navigation.navigationUi)

    "api"(Paging.paging)
    "api"(Paging.pagingTest)
}