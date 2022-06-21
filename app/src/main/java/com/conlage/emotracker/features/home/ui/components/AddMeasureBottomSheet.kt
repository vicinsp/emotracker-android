package com.conlage.emotracker.features.home.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.components.TopBar
import com.conlage.emotracker.features.home.domain.entity.Activity
import com.conlage.emotracker.features.home.domain.entity.Situation
import com.google.accompanist.flowlayout.FlowRow
import com.conlage.emotracker.components.Button
import com.conlage.emotracker.theme.AppTheme


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun AddMeasureBottomSheet(
   activities: List<Activity>,
   situations: List<Situation>,
   addMeasure: (activityId: Int, situationId: Int, mood: Int) -> Unit,
) {

   val selectedActivity: MutableState<Int?> = remember { mutableStateOf(null) }
   val selectedSituation: MutableState<Int?> = remember { mutableStateOf(null) }
   val moodValue: MutableState<Float> = remember { mutableStateOf(7f) }

   Column(
      Modifier
         .padding(horizontal = 16.dp)
         .padding(bottom = 16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {

      TopBar(title = "Новое измерение")

      PickActivityContent(
         activities = activities,
         selectedId = selectedActivity.value,
         updateSelectedActivity = { id ->
            selectedActivity.value = id
         }
      )

      PickSituationContent(
         situations = situations,
         selectedId = selectedSituation.value,
         updateSelectedActivity = { id ->
            selectedSituation.value = id
         }
      )

      PickMoodContent(
         value = moodValue.value,
         updateValue = { newVal ->
            moodValue.value = newVal
         }
      )

      Button(
         text = "Создать",
         enabled = selectedActivity.value != null
                 && selectedSituation.value != null,
         onClick = {
            addMeasure(selectedActivity.value!!, selectedSituation.value!!, moodValue.value.toInt())
         }
      )
   }
}

@Composable
fun PickActivityContent(
   activities: List<Activity>,
   selectedId: Int?,
   updateSelectedActivity: (id: Int) -> Unit
) {

   Text(text = "Чем занимались?")
   FlowRow(mainAxisSpacing = 8.dp, crossAxisSpacing = 8.dp) {
      activities.forEach { activity ->
         Cheap(title = activity.title, selected = activity.id == selectedId) {
            updateSelectedActivity(activity.id)
         }
      }
   }
}


@Composable
private fun PickSituationContent(
   situations: List<Situation>,
   selectedId: Int?,
   updateSelectedActivity: (id: Int) -> Unit
) {

   Text(text = "Что произошло?")
   FlowRow(mainAxisSpacing = 8.dp, crossAxisSpacing = 8.dp) {
      situations.forEach { situation ->
         Cheap(title = situation.title, selected = situation.id == selectedId) {
            updateSelectedActivity(situation.id)
         }
      }
   }
}

@Composable
private fun PickMoodContent(
   value: Float,
   updateValue: (newVal: Float) -> Unit
) {

   Text(text = "Настроение и самочувствие от 0 до 10:")
   Slider(
      value = value,
      onValueChange = updateValue,
      steps = 9,
      colors = SliderDefaults.colors(
         thumbColor = AppTheme.colors.mainColor,
         activeTrackColor = AppTheme.colors.mainColor,
         inactiveTrackColor = AppTheme.colors.mainColor.copy(0.5f),
         activeTickColor = AppTheme.colors.mainColor,
         inactiveTickColor =AppTheme.colors.mainColor.copy(0.5f),
      ),
      valueRange = 0f..10f
   )
}