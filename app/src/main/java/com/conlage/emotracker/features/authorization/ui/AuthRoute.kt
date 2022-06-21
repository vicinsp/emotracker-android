package com.conlage.emotracker.features.authorization.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.conlage.emotracker.components.ErrorDialog

@Composable
fun AuthRoute(
   navigateToRegisterRoute: () -> Unit,
   navigateToHomeRoute: () -> Unit
) {

   val viewModel: AuthViewModel = hiltViewModel()
   val uiState = viewModel.uiState.collectAsState()

   AuthScreen(
      uiState = uiState.value,
      authorize = { viewModel.authorize(navigateToHomeRoute) },
      navigateToRegistration = navigateToRegisterRoute,
      onEmailChanged = viewModel::updateEmail,
      onPasswordChanged = viewModel::updatePassword,
   )

   ErrorDialog(message = uiState.value.errorMessage, onDismiss = viewModel::hideError)
}