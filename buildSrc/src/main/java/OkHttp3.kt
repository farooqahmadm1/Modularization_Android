object OkHttp3 {
    // define a BOM and its version and define any required OkHttp artifacts without version
    private const val version = "4.9.3"
    const val BOM = "com.squareup.okhttp3:okhttp-bom:$version"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val logger = "com.squareup.okhttp3:logging-interceptor"
}