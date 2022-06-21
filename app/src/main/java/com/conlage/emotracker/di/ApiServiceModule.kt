package com.conlage.emotracker.di

import com.conlage.emotracker.features.authorization.data.AuthApiService
import com.conlage.emotracker.features.home.data.repository.HomeApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

   @Provides
   fun provideAuthApiService(retrofit: Retrofit): AuthApiService =
      retrofit.create(AuthApiService::class.java)

   @Provides
   fun provideHomeApiService(retrofit: Retrofit): HomeApiService =
      retrofit.create(HomeApiService::class.java)
}