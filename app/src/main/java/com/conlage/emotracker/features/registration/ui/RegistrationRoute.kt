package com.conlage.emotracker.features.registration.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegistrationRoute(
   navigateToHomeRoute: () -> Unit,
   navigateToAuthRoute: () -> Unit,
) {

   val viewModel: RegistrationViewModel = hiltViewModel()
   val uiState = viewModel.uiState.collectAsState()

   RegistrationScreen(
      uiState = uiState.value,
      authorize = { viewModel.registerUser(navigateToHomeRoute) },
      navigateToAuthorization = navigateToAuthRoute,
      onNameChanged = viewModel::updateName,
      onEmailChanged = viewModel::updateEmail,
      onPasswordChanged = viewModel::updatePassword,
      onPassword2Changed = viewModel::updatePassword2,
   )
}