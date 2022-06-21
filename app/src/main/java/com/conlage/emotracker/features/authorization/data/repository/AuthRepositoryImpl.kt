package com.conlage.emotracker.features.authorization.data.repository

import com.conlage.emotracker.features.authorization.data.AuthApiService
import com.conlage.emotracker.features.authorization.data.PerformAuthRequest
import com.conlage.emotracker.features.authorization.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
   private val authApiService: AuthApiService
) : AuthRepository {

   override suspend fun authorize(email: String, password: String): String =
      authApiService.performAuthorization(
         PerformAuthRequest(
            email = email,
            password = password
         )
      ).response
}