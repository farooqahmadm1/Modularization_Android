plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
}

android {

    namespace = "com.farooq.module_demo"
    compileSdk = 33
    buildToolsVersion = "33.0.0"

    defaultConfig {
        applicationId = "com.farooq.module_demo"
        minSdkVersion(21)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        testInstrumentationRunner = "com.farooq.lastfm.MyTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildTypes {
            getByName("debug") {
                isShrinkResources = false
                isMinifyEnabled = false
            }
            getByName("release") {
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
    implementation(project(":rss:ui-feeds"))
    implementation(project(":rss:ui-stories"))
    implementation(project(":rss:data"))

    /**
     * GOOGLE
     * data <------ domain ----------->uifeeds -------> app
     *
     */
    implementation("com.google.android.material:material:1.6.0")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.material3:material3:1.1.0-alpha06")
    testImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("com.google.truth:truth:1.0.1")


    /**
     * Kotlin
     */
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.20")

    /**
     * Hilt
     */
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-compiler:2.43.2")
    androidTestImplementation("com.google.dagger:hilt-android-compiler:2.43.2")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.43.2")

//    testImplementation(Junit.junit4)
//    androidTestImplementation(Junit.junit4)
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.5.1")

}


// Allow references to generated code
kapt {
    correctErrorTypes = true
}