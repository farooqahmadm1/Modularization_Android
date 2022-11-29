object Room {

    // https://developer.android.com/training/data-storage/room

    private val room_version = "2.4.3"

    val kotlin = "androidx.room:room-ktx:$room_version"
    val runtime = "androidx.room:room-runtime:$room_version"
    // To use Kotlin annotation processing tool (kapt)
    val compiler = "androidx.room:room-compiler:$room_version"
    // optional - Guava support for Room, including Optional and ListenableFuture
    val guava = "androidx.room:room-guava:$room_version"
    // optional - RxJava3 support for Room
    val rxjava3 = "androidx.room:room-rxjava3:$room_version"

    // optional - Paging 3 Integration
    val paging = "androidx.room:room-paging:$room_version"

    val test = "androidx.room:room-testing:$room_version"
}