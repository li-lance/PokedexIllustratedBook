plugins {
  id("fate.android-app-default")
  id("fate.android-compose")
}
android {
  defaultConfig {
    applicationId = "com.pokedex.illustratedbook"
  }
}
dependencies{
  implementation(Lib.AndroidX.appcompat)
  implementation(Lib.AndroidX.coreSplash)
  implementation(Lib.AndroidX.fragmentKtx)
  implementation(Lib.materialComponents)
}