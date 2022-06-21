package com.conlage.emotracker.di

import com.conlage.emotracker.common.Constants
import com.conlage.emotracker.features.authorization.domain.repository.AccessTokenRepository
import com.conlage.emotracker.utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

   @Qualifier
   @Retention(AnnotationRetention.BINARY)
   annotation class AuthInterceptor

   @Qualifier
   @Retention(AnnotationRetention.BINARY)
   annotation class AuthInterceptorOkHttpClient

   @AuthInterceptor
   @Provides
   fun provideAuthInterceptor(accessTokenRepository: AccessTokenRepository): Interceptor =
      AuthInterceptor(accessTokenRepository = accessTokenRepository)

   @AuthInterceptorOkHttpClient
   @Provides
   fun provideAuthInterceptorOkHttpClient(@AuthInterceptor authInterceptor: Interceptor): OkHttpClient =
      OkHttpClient.Builder().addInterceptor(interceptor = authInterceptor).build()

   @Provides
   @Singleton
   fun provideRetrofit(@AuthInterceptorOkHttpClient client: OkHttpClient): Retrofit =
      Retrofit.Builder()
         .baseUrl(Constants.BASE_URL)
         .client(client)
         .addConverterFactory(GsonConverterFactory.create())
         .build()
}