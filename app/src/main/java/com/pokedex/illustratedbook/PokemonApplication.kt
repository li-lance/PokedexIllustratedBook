package com.pokedex.illustratedbook

import android.app.Application
import com.fate.android.log.initLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokemonApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    initLogger(BuildConfig.DEBUG)
  }
}