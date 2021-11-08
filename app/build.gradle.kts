plugins {
  id("fate.android-app-default")
  id("fate.android-compose")
  id("dagger.hilt.android.plugin")
  id("kotlin-parcelize")
}
android {
  defaultConfig {
    applicationId = "com.pokedex.illustratedbook"
  }
}
dependencies {
  implementation(Lib.AndroidX.appcompat)
  implementation(Lib.AndroidX.coreSplash)
  implementation(Lib.AndroidX.fragmentKtx)
  implementation(Lib.AndroidX.dataStore)
  implementation(Lib.gson)
  implementation(Lib.materialComponents)
  implementation(Lib.Dagger.hilt)
  kapt(Lib.Dagger.hiltCompiler)
  implementation(Lib.Dagger.composeNavigation)
  implementation(Lib.Retrofit.retrofit)
  implementation(Lib.Retrofit.retrofitGson)
  implementation(Lib.Retrofit.retrofitScalars)
  implementation(Lib.okHttp3LoggingInterceptor)
  implementation(Lib.KotlinX.coroutinesAndroid)
  implementation(Lib.viewbindingpropertydelegate)

  debugImplementation(Lib.Chucker.debug)
  releaseImplementation(Lib.Chucker.release)
}