package com.conlage.emotracker.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.conlage.emotracker.utils.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

   @Qualifier
   @Retention(AnnotationRetention.BINARY)
   annotation class AccessTokenDataStore

   @AccessTokenDataStore
   @Provides
   fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> =
      appContext.dataStore
}

