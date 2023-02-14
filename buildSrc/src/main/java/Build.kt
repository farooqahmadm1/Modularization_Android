import org.gradle.api.tasks.TaskAction

object Build {
    private const val androidBuildToolsVersion = "7.3.1"
    const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltAndroid = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.hiltVersion}"
    const val sqlDelightGradlePlugin = "com.squareup.sqldelight:gradle-plugin:${SqlDelight.version}"
    const val navigationSafe = "androidx.navigation:navigation-safe-args-gradle-plugin:${Navigation.navigationVersion}"
}