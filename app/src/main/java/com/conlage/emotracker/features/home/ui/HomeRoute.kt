package com.conlage.emotracker.features.home.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.conlage.emotracker.components.ErrorDialog

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun HomeRoute() {
   val viewModel: HomeViewModel = hiltViewModel()
   val uiState = viewModel.uiState.collectAsState()
   HomeScreen(uiState = uiState.value)
   ErrorDialog(message = uiState.value.errorMessage, onDismiss = viewModel::hideError)
}