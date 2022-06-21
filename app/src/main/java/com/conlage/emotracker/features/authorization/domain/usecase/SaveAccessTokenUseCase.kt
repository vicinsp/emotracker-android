package com.conlage.emotracker.features.authorization.domain.usecase

import android.content.Context
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.authorization.domain.repository.AccessTokenRepository
import com.conlage.emotracker.features.authorization.domain.repository.AuthRepository
import com.conlage.emotracker.utils.emitSuccess
import com.conlage.emotracker.utils.flow
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveAccessTokenUseCase @Inject constructor(
   @ApplicationContext
   private val context: Context,
   private val repository: AccessTokenRepository
) {

   suspend operator fun invoke(token: String) {
      repository.saveToken(value = token)
   }
}