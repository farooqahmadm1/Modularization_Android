object AndroidX {
    /*
     * Android Versions
     * https://developer.android.com/jetpack/androidx/versions
     */
    private const val coreKtxVersion = "1.8.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val appCompatVersion = "1.5.0"
    const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"

    private const val recyclerviewVersion = "1.2.1"
    const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerviewVersion"

    private const val browserVersion = "1.4.0"
    const val browser = "androidx.browser:browser:$browserVersion"

    private const val activityVersion = "1.5.1"
    const val activity = "androidx.activity:activity-ktx:$activityVersion"

    private const val fragmentVersion = "1.5.2"
    const val fragment = "androidx.fragment:fragment-ktx:$fragmentVersion"

    private const val legacySupportV4Version = "1.0.0"
    const val legacySupport = "androidx.legacy:legacy-support-v4:$legacySupportV4Version"

    private const val constraintLayoutVersion = "2.1.3"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

    private const val lifecycleVmKtxVersion = "2.5.1"
    const val lifecycleVmKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVmKtxVersion"
    const val lifecycleLdKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVmKtxVersion"
    const val lifecycleRtKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
}

object AndroidXTest {
    private const val version = "1.3.0"
    const val runner = "androidx.test:runner:$version"
}