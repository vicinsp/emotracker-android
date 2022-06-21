package com.conlage.emotracker.features.home.data.repository

import com.conlage.emotracker.features.home.domain.HomeRepository
import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.domain.entity.Situation
import com.conlage.emotracker.features.home.domain.entity.UserData
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
   private val homeApiService: HomeApiService
) : HomeRepository {

   override suspend fun getUserData(): UserData =
      homeApiService.getUserData()

   override suspend fun getActivities(): List<Activity> =
      homeApiService.getActivities().activities

   override suspend fun getSituations(): List<Situation> =
      homeApiService.getSituations().situations

   override suspend fun createMeasure(activityId: Int, situationId: Int, moodScore: Int) =
      homeApiService.createNewMeasure()
}