plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {

    namespace = Config.Application.applicationId
    compileSdk = Android.compileSdk
    buildToolsVersion = Android.buildTools

    defaultConfig {
        applicationId = Config.Application.applicationId
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = Android.versionCode
        versionName = Android.versionName
        multiDexEnabled = true
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        testInstrumentationRunner = "com.farooq.lastfm.MyTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildTypes {
            getByName(Config.Variants.debug) {
                isShrinkResources = false
                isMinifyEnabled = false
            }
            getByName(Config.Variants.release) {
                isShrinkResources = true
                isMinifyEnabled = true
            }
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":android-components"))
    implementation(project(Modules.ui_rssFeeds))
    implementation(project(Modules.ui_rssStories))
    implementation(project(Modules.rssData))

    /**
     * GOOGLE
     * data <------ domain ----------->uifeeds -------> app
     *
     */
    implementation(Google.material)
    implementation(Google.gson)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.material3:material3:1.1.0-alpha06")
    testImplementation(Google.truth)
    androidTestImplementation(Google.truth)


    /**
     * Kotlin
     */
    implementation(Kotlin.kotlinStdlib)

    /**
     * Hilt
     */
    implementation(Hilt.android)
    kapt(Hilt.compiler)
    androidTestImplementation(HiltTest.hiltAndroidTesting)
    kaptAndroidTest(HiltTest.hiltKaptTesting)

    testImplementation(Junit.junit4)
    androidTestImplementation(Junit.junit4)
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1")

}


// Allow references to generated code
kapt {
    correctErrorTypes = true
}