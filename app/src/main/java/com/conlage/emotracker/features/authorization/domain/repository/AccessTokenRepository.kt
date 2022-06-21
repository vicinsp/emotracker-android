package com.conlage.emotracker.features.authorization.domain.repository

interface AccessTokenRepository {

   suspend fun saveToken(value: String)
   suspend fun getToken(): String
   suspend fun removeToken()
   suspend fun isTokenExist(): Boolean
}