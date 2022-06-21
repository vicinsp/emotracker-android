package com.conlage.emotracker.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.conlage.emotracker.features.authorization.data.AuthApiService
import com.conlage.emotracker.features.authorization.data.repository.AccessTokenRepositoryImpl
import com.conlage.emotracker.features.authorization.data.repository.AuthRepositoryImpl
import com.conlage.emotracker.features.authorization.domain.repository.AccessTokenRepository
import com.conlage.emotracker.features.authorization.domain.repository.AuthRepository
import com.conlage.emotracker.features.home.data.repository.HomeApiService
import com.conlage.emotracker.features.home.data.repository.HomeRepositoryImpl
import com.conlage.emotracker.features.home.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

   @Provides
   fun provideAuthRepository(authApiService: AuthApiService): AuthRepository =
      AuthRepositoryImpl(authApiService = authApiService)

   @Provides
   fun provideAccessTokenRepository(@DataStoreModule.AccessTokenDataStore dataStore: DataStore<Preferences>): AccessTokenRepository =
      AccessTokenRepositoryImpl(dataStore = dataStore)

   @Provides
   fun provideHomeRepository(homeApiService: HomeApiService): HomeRepository =
      HomeRepositoryImpl(homeApiService = homeApiService)
}