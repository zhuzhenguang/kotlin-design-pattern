import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
}

group = "org.napoleon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.logback)
    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.test)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
