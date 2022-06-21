package com.conlage.emotracker.features.metrics.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

data class MetricsUiState(
   val isLoading: Boolean,
   val userName: String,
   val email: String,
   val averageMood: Float,
   val errorMessage: String?
)

data class MetricsViewModelState(
   val isLoading: Boolean = false,
   val userName: String = "Имя пользователя",
   val email: String = "",
   val averageMood: Float = 0.0f,
   val errorMessage: String? = null
) {

   fun toUiState(): MetricsUiState = MetricsUiState(
      isLoading = isLoading,
      userName = userName,
      email = email,
      averageMood = averageMood,
      errorMessage = errorMessage
   )
}

@HiltViewModel
class MetricsViewModel @Inject constructor() : ViewModel() {

   private val vmState = MutableStateFlow(MetricsViewModelState())

   val uiState = vmState
      .map { it.toUiState() }
      .stateIn(
         viewModelScope,
         SharingStarted.Eagerly,
         vmState.value.toUiState()
      )

   fun getInfo(onRegisterComplete: () -> Unit) {}
}