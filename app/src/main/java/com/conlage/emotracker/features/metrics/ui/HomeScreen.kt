package com.conlage.emotracker.features.metrics.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.R
import com.conlage.emotracker.components.Button
import com.conlage.emotracker.components.TopBar
import com.conlage.emotracker.features.home.ui.components.AverageValueWidget
import com.conlage.emotracker.features.home.ui.components.HomeProfileInfo
import com.conlage.emotracker.features.home.ui.components.WatchStatButton
import com.conlage.emotracker.navigation.Destination
import com.conlage.emotracker.theme.AppTheme

@Composable
fun MetricsScreen(uiState: MetricsUiState) {
   Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(16.dp)
   ) {
      TopBar(title = Destination.Home.name, withBackArrow = true)
      
      Text(text = "Список измерений")

   }
}