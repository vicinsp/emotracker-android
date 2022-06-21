package com.conlage.emotracker.features.home.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.R
import com.conlage.emotracker.components.ErrorDialog
import com.conlage.emotracker.components.TopBar
import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.ui.components.AddMeasureBottomSheet
import com.conlage.emotracker.features.home.ui.components.AverageValueWidget
import com.conlage.emotracker.features.home.ui.components.HomeProfileInfo
import com.conlage.emotracker.features.home.ui.components.WatchStatButton
import com.conlage.emotracker.navigation.Destination
import com.conlage.emotracker.theme.AppTheme
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(uiState: HomeUiState) {
   Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(16.dp)
   ) {

      val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
      val coroutineScope = rememberCoroutineScope()

      ModalBottomSheetLayout(
         sheetState = sheetState,
         sheetContent = {
            AddMeasureBottomSheet(
               activities = uiState.activities,
               situations = uiState.situations,
               addMeasure = { activityId, situationId, mood ->

               })
         },
         content = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
               TopBar(title = Destination.Home.name)
               HomeProfileInfo(userName = uiState.userName, email = uiState.email) {}
               Text(text = "Средняя оценка:", Modifier.padding(start = 16.dp))
               AverageValueWidget(value = uiState.averageMood)
               Text(text = "Статистика:", Modifier.padding(start = 16.dp))
               WatchStatButton {}
               Spacer(modifier = Modifier.weight(1f))
               FloatingActionButton(
                  onClick = { coroutineScope.launch { sheetState.animateTo(ModalBottomSheetValue.Expanded) } },
                  modifier = Modifier
                     .padding(16.dp)
                     .align(End),
                  backgroundColor = AppTheme.colors.mainColor
               ) {
                  Icon(
                     painter = painterResource(id = R.drawable.ic_password),
                     contentDescription = null,
                     tint = Color.White
                  )
               }
            }
         })
   }
}