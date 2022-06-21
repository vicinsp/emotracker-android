package com.conlage.emotracker.features.home.data.repository

import com.conlage.emotracker.common.ResponseWrapper
import com.conlage.emotracker.features.home.data.model.ActivitiesResponse
import com.conlage.emotracker.features.home.data.model.SituationsResponse
import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.domain.entity.Situation
import com.conlage.emotracker.features.home.domain.entity.UserData
import retrofit2.http.*

interface HomeApiService {

   @GET("userData")
   suspend fun getUserData(): UserData

   @Headers("No-Authentication: true")
   @GET("activities")
   suspend fun getActivities(): ActivitiesResponse

   @Headers("No-Authentication: true")
   @GET("situations")
   suspend fun getSituations(): SituationsResponse

   @POST("measure")
   suspend fun createNewMeasure()
}