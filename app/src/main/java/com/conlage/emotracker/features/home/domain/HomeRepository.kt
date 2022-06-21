package com.conlage.emotracker.features.home.domain

import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.domain.entity.Situation
import com.conlage.emotracker.features.home.domain.entity.UserData

interface HomeRepository {

   suspend fun getUserData(): UserData
   suspend fun getActivities(): List<Activity>
   suspend fun getSituations(): List<Situation>
   suspend fun createMeasure(activityId: Int, situationId: Int, moodScore: Int)
}