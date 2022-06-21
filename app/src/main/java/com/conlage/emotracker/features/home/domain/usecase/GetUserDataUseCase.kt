package com.conlage.emotracker.features.home.domain.usecase

import android.content.Context
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.home.domain.HomeRepository
import com.conlage.emotracker.features.home.domain.entity.Situation
import com.conlage.emotracker.features.home.domain.entity.UserData
import com.conlage.emotracker.utils.emitSuccess
import com.conlage.emotracker.utils.flow
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(
   @ApplicationContext
   val context: Context,
   private val homeRepository: HomeRepository
) {

   operator fun invoke(): Flow<RequestResult<UserData>> = flow(context) {
      val userData = homeRepository.getUserData()
      emitSuccess(userData)
   }
}