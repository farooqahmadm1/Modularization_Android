object Google {

    /*
     * Google Maven Repository
     * https://maven.google.com/web/index.html#com.google.android.material:material
     * Material Github
     * https://github.com/material-components/material-components-android/releases
     */

    private const val materialVersion = "1.6.0"
    const val material = "com.google.android.material:material:$materialVersion"

    /*
     * Google Play Services Versions
     * https://developers.google.com/android/guides/setup
     */

    private const val playServicesMapsVersion = "18.1.0"
    private const val playServicesLocationVersion = "20.0.0"
    private const val playServicesGcmVersion = "17.0.0"
    private const val playServicesVisionVersion = "20.1.3"
    private const val playServicesPlacesVersion = "2.5.0"
    private const val playServicesUtilsVersion = "2.3.0"

    const val playServicesGcm = "com.google.android.gms:play-services-gcm:$playServicesGcmVersion"
    const val playServicesMap = "com.google.android.gms:play-services-maps:$playServicesMapsVersion"
    const val playServicesVision = "com.google.android.gms:play-services-vision:$playServicesVisionVersion"
    const val playServicesLocation = "com.google.android.gms:play-services-location:$playServicesLocationVersion"

    const val playServicesPlaces = "com.google.android.libraries.places:places:$playServicesPlacesVersion"
    const val playServicesUtils = "com.google.maps.android:android-maps-utils:$playServicesUtilsVersion"

    /*
     * Google Services Plugin Version
     * https://developers.google.com/android/guides/google-services-plugin
     */
    const val googleServicesVersion = "4.3.10"


    /*
     * Google Gson Library
     * https://github.com/google/gson
     */
    private const val gsonVersion = "2.8.9"
    const val gson = "com.google.code.gson:gson:$gsonVersion"



    const val accompanist = "com.google.accompanist:accompanist-flowlayout:0.17.0"


    /*
     * Google Truth for testing
     */
    const val truth = "com.google.truth:truth:1.0.1"

}