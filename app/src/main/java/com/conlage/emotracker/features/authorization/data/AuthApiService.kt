package com.conlage.emotracker.features.authorization.data

import com.conlage.emotracker.common.ResponseWrapper
import retrofit2.http.*

interface AuthApiService {

   @Headers("No-Authentication: true")
   @POST("auth")
   suspend fun performAuthorization(
      @Body performAuthRequest: PerformAuthRequest
   ): ResponseWrapper<String>
}