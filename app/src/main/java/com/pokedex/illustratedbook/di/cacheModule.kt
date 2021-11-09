package com.pokedex.illustratedbook.di

import android.content.Context
import com.google.gson.Gson
import com.pokedex.illustratedbook.data.PokemonCache
import com.pokedex.illustratedbook.data.PokemonCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {
  @Singleton
  @Provides
  fun providePokemonCache(@ApplicationContext context: Context, gson: Gson): PokemonCache =
    PokemonCacheImpl(context, gson)
}