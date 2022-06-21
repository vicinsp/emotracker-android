package com.conlage.emotracker.features.authorization.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.conlage.emotracker.common.RequestResult
import com.conlage.emotracker.features.authorization.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AuthUiState(
   val isLoading: Boolean,
   val email: String,
   val password: String,
   val errorMessage: String?
)

data class AuthViewModelState(
   val isLoading: Boolean = false,
   val email: String = "",
   val password: String = "",
   val errorMessage: String? = null
) {

   fun toUiState(): AuthUiState = AuthUiState(
      isLoading = isLoading,
      email = email,
      password = password,
      errorMessage = errorMessage
   )
}

@HiltViewModel
class AuthViewModel @Inject constructor(
   private val authUseCase: AuthUseCase
) : ViewModel() {

   private val vmState = MutableStateFlow(AuthViewModelState())

   val uiState = vmState
      .map { it.toUiState() }
      .stateIn(
         viewModelScope,
         SharingStarted.Eagerly,
         vmState.value.toUiState()
      )

   fun authorize(onAuthComplete: () -> Unit) {
      val email = vmState.value.email
      val password = vmState.value.password
      if (!isValidEmailAndPassword(email = email, password = password)) return
      authUseCase(
         email = vmState.value.email,
         password = vmState.value.password
      ).onEach { result ->
         when (result) {
            is RequestResult.Success -> onAuthComplete()
            is RequestResult.Error -> vmState.update { it.copy(errorMessage = result.errorMessage) }
         }
      }.launchIn(viewModelScope)
}

fun hideError() = vmState.update { it.copy(errorMessage = null) }

fun updateEmail(newValue: String) = vmState.update { it.copy(email = newValue) }

fun updatePassword(newValue: String) = vmState.update { it.copy(password = newValue) }

private fun isValidEmailAndPassword(email: String, password: String): Boolean =
   email.isNotEmpty() && password.isNotEmpty()
}