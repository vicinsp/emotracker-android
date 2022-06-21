package com.conlage.emotracker.features.home.domain.usecase

import android.content.Context
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.authorization.data.AuthApiService
import com.conlage.emotracker.features.home.domain.HomeRepository
import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.utils.emitSuccess
import com.conlage.emotracker.utils.flow
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetActivitiesUseCase @Inject constructor(
   @ApplicationContext
   val context: Context,
   private val homeRepository: HomeRepository
) {

   operator fun invoke(): Flow<RequestResult<List<Activity>>> = flow(context) {
      val activities = homeRepository.getActivities()
      emitSuccess(activities)
   }
}