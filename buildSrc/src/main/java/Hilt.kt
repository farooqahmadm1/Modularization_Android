object Hilt {
    const val hiltVersion = "2.43.2"
    const val android = "com.google.dagger:hilt-android:$hiltVersion"
    const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    const val androidCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
}

object HiltTest {
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Hilt.hiltVersion}"
    const val hiltKaptTesting= "com.google.dagger:hilt-android-compiler:${Hilt.hiltVersion}"
}