object Firebase {


    /*
     * Firebase Version BoM
     * https://firebase.google.com/support/release-notes/android
     */

    private const val firebaseBomVersion = "30.3.1"

    const val firebaseBom = "com.google.firebase:firebase-bom:$firebaseBomVersion"
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseStorageKtx = "com.google.firebase:firebase-storage-ktx"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging-ktx"

    /*
     * Firebase Crashlytics plugin version
     * https://mvnrepository.com/artifact/com.google.firebase/firebase-crashlytics-gradle?repo=google
     */
    const val firebaseCrashlyticsVersion = "2.7.1"
}