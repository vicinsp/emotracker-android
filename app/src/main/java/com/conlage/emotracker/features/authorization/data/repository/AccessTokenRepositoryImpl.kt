package com.conlage.emotracker.features.authorization.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.conlage.emotracker.features.authorization.domain.repository.AccessTokenRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AccessTokenRepositoryImpl @Inject constructor(
   private val dataStore: DataStore<Preferences>
) : AccessTokenRepository {

   companion object {

      private val AUTH_TOKEN_KEY = stringPreferencesKey("access_token")
   }

   private val token = dataStore.data.map { it[AUTH_TOKEN_KEY] }

   override suspend fun saveToken(value: String) {
      dataStore.edit {
         it[AUTH_TOKEN_KEY] = value
      }
   }

   override suspend fun removeToken() {
      dataStore.edit {
         it[AUTH_TOKEN_KEY] = ""
      }
   }

   override suspend fun getToken(): String = token.first() ?: "b1cf3444-ece2-4e6f-bb66-8bf3426105bf"

   override suspend fun isTokenExist(): Boolean = getToken().isNotEmpty()
}