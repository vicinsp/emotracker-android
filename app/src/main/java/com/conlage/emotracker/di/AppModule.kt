package com.conlage.emotracker.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
   includes = [
      DataStoreModule::class,
      NetworkModule::class,
      ApiServiceModule::class,
      RepositoryModule::class,
   ]
)
@InstallIn(SingletonComponent::class)
object AppModule