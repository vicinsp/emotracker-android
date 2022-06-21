package com.conlage.emotracker.features.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.domain.entity.Situation
import com.conlage.emotracker.features.home.domain.usecase.GetActivitiesUseCase
import com.conlage.emotracker.features.home.domain.usecase.GetSituationsUseCase
import com.conlage.emotracker.features.home.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

data class HomeUiState(
   val isLoading: Boolean,
   val userName: String,
   val email: String,
   val activities: List<Activity>,
   val situations: List<Situation>,
   val averageMood: Float?,
   val errorMessage: String?
)

data class HomeViewModelState(
   val isLoading: Boolean = false,
   val userName: String = "Виктор",
   val email: String = "vicinsp@email.ru",
   val activities: List<Activity> = emptyList(),
   val situations: List<Situation> = emptyList(),
   val averageMood: Float? = null,
   val errorMessage: String? = null
) {

   fun toUiState(): HomeUiState = HomeUiState(
      isLoading = isLoading,
      userName = userName,
      email = email,
      averageMood = averageMood,
      errorMessage = errorMessage,
      activities = activities,
      situations = situations
   )
}

@HiltViewModel
class HomeViewModel @Inject constructor(
   val getActivitiesUseCase: GetActivitiesUseCase,
   val getSituationsUseCase: GetSituationsUseCase,
   val getUserDataUseCase: GetUserDataUseCase
) : ViewModel() {

   private val vmState = MutableStateFlow(HomeViewModelState())

   val uiState = vmState
      .map { it.toUiState() }
      .stateIn(
         viewModelScope,
         SharingStarted.Eagerly,
         vmState.value.toUiState()
      )

   init {
      fetchUserData()
      fetchSituations()
      fetchActivities()
   }

   private fun fetchUserData() {
      getUserDataUseCase().onEach { result ->
         when (result) {
            is RequestResult.Success -> {
               vmState.update {
                  it.copy(
                     email = result.data.email,
                     userName = result.data.name,
                     averageMood = result.data.averageMood
                  )
               }
            }
            is RequestResult.Error -> {
               vmState.update { it.copy(errorMessage = result.errorMessage) }
            }
         }
      }.launchIn(viewModelScope)
   }

   private fun fetchSituations() {
      getSituationsUseCase().onEach { result ->
         when (result) {
            is RequestResult.Success -> {
               vmState.update { it.copy(situations = result.data) }
            }
            is RequestResult.Error -> {
               vmState.update { it.copy(errorMessage = result.errorMessage) }
            }
         }
      }.launchIn(viewModelScope)
   }

   private fun fetchActivities() {
      getActivitiesUseCase().onEach { result ->
         when (result) {
            is RequestResult.Success -> {
               vmState.update { it.copy(activities = result.data) }
            }
            is RequestResult.Error -> {
               vmState.update { it.copy(errorMessage = result.errorMessage) }
            }
         }
      }.launchIn(viewModelScope)
   }

   fun hideError() {
      vmState.update { it.copy(errorMessage = null) }
   }
}