import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    gradlePluginPortal()
    mavenCentral()
}
//
plugins {
    `kotlin-dsl`
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}