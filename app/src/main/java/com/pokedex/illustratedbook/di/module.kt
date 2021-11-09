package com.pokedex.illustratedbook.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.pokedex.illustratedbook.BuildConfig
import com.pokedex.illustratedbook.api.ApiService
import com.pokedex.illustratedbook.model.ApiResource
import com.pokedex.illustratedbook.model.NamedApiResource
import com.pokedex.illustratedbook.model.adapter.ApiResourceAdapter
import com.pokedex.illustratedbook.model.adapter.NamedApiResourceAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
  private const val BASE_URL = "https://pokeapi.co/api/v2/"

  @Singleton
  @Provides
  fun provideGson(): Gson = GsonBuilder().create()

  @Singleton
  @Provides
  fun provideOkhttpClient(@ApplicationContext context: Context): OkHttpClient =
    OkHttpClient.Builder().apply {
      retryOnConnectionFailure(false)
      connectTimeout(30, TimeUnit.SECONDS)
      readTimeout(30, TimeUnit.SECONDS)
      writeTimeout(30, TimeUnit.SECONDS)
      addInterceptor(HttpLoggingInterceptor().apply {
        level =
          if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC
      })
      addInterceptor(ChuckerInterceptor.Builder(context).build())
    }.build()

  @Singleton
  @Provides
  fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(client)
      .addConverterFactory(GsonConverterFactory.create(GsonBuilder().apply {
        setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        registerTypeAdapter(
          TypeToken.get(ApiResource::class.java).type,
          ApiResourceAdapter()
        )
        registerTypeAdapter(
          TypeToken.get(NamedApiResource::class.java).type,
          NamedApiResourceAdapter()
        )
      }.create()))
      .build()

  @Singleton
  @Provides
  fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}