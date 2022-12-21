import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.kotlin.dsl.`kotlin-dsl`


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