// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  idea
}
subprojects {
  repositories {
    mavenCentral()
    google()
    maven { url = uri("https://jitpack.io") }
    jcenter()
  }
}

//buildscript {
//  ext {
//    compose_version = '1.0.1'
//  }
//  repositories {
//    google()
//    mavenCentral()
//  }
//  dependencies {
//    classpath "com.android.tools.build:gradle:7.0.3"
//    classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21"
//
//    // NOTE: Do not place your application dependencies here; they belong
//    // in the individual module build.gradle files
//  }
//}
//
//task clean(type: Delete) {
//  delete rootProject.buildDir
//}