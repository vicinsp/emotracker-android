package com.conlage.emotracker.utils

import com.conlage.emotracker.features.authorization.domain.repository.AccessTokenRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
   private val accessTokenRepository: AccessTokenRepository
) : Interceptor {
   override fun intercept(chain: Interceptor.Chain): Response {
      val request = chain.request().newBuilder()
      if (chain.request().header("No-Authentication") == null) {
         val token = runBlocking {
            accessTokenRepository.getToken()
         }
         println("token $token")
         request.addHeader("Authorization", "Bearer $token")
      }
      return chain.proceed(request.build())
   }
}