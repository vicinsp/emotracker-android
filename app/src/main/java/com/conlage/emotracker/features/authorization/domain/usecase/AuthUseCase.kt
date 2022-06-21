package com.conlage.emotracker.features.authorization.domain.usecase

import android.content.Context
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.authorization.domain.repository.AuthRepository
import com.conlage.emotracker.utils.emitSuccess
import com.conlage.emotracker.utils.flow
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject

@ExperimentalCoroutinesApi
class AuthUseCase @Inject constructor(
   @ApplicationContext
   private val context: Context,
   private val repository: AuthRepository,
   private val saveAccessTokenUseCase: SaveAccessTokenUseCase
) {

   operator fun invoke(email: String, password: String): Flow<RequestResult<Unit>> = flow(context) {
      val token = repository.authorize(email = email, password = password)
      saveAccessTokenUseCase(token = token)
      emitSuccess()
   }
}