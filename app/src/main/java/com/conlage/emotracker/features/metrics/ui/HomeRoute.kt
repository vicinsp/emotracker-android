package com.conlage.emotracker.features.metrics.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MetricsRoute() {
   val viewModel: MetricsViewModel = hiltViewModel()
   val uiState = viewModel.uiState.collectAsState()
   MetricsScreen(uiState = uiState.value)
}