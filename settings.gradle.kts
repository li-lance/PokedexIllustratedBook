pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
  }
}


buildscript {
  repositories {
    mavenCentral()
    google()
    maven { url = uri("https://jitpack.io") }
  }
}
include("dependencies")
include("app")
//include("android-commons")
