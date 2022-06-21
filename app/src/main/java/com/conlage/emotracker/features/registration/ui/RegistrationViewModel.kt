package com.conlage.emotracker.features.registration.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.authorization.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class RegistrationUiState(
   val isLoading: Boolean,
   val name: String,
   val email: String,
   val password: String,
   val password2: String,
   val errorMessage: String?
)

data class RegistrationViewModelState(
   val isLoading: Boolean = false,
   val name: String = "",
   val email: String = "",
   val password: String = "",
   val password2: String = "",
   val errorMessage: String? = null
) {

   fun toUiState(): RegistrationUiState = RegistrationUiState(
      isLoading = isLoading,
      name = name,
      email = email,
      password = password,
      password2 = password,
      errorMessage = errorMessage
   )
}

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {

   private val vmState = MutableStateFlow(RegistrationViewModelState())

   val uiState = vmState
      .map { it.toUiState() }
      .stateIn(
         viewModelScope,
         SharingStarted.Eagerly,
         vmState.value.toUiState()
      )

   fun registerUser(onRegisterComplete: () -> Unit) {}

   fun updateName(newValue: String) = vmState.update { it.copy(name = newValue) }
   fun updateEmail(newValue: String) = vmState.update { it.copy(email = newValue) }
   fun updatePassword(newValue: String) = vmState.update { it.copy(password = newValue) }
   fun updatePassword2(newValue: String) = vmState.update { it.copy(password2 = newValue) }
}