// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    }

    dependencies {
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
        classpath(Build.navigationSafe)
        classpath(Build.hiltAndroid)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}