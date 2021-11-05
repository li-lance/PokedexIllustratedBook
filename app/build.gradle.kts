plugins {
  id("fate.android-app-default")
  id("fate.android-compose")
  id("dagger.hilt.android.plugin")
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
  implementation(Lib.Dagger.hilt)
  kapt(Lib.Dagger.hiltCompiler)

}