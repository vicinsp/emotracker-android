package com.conlage.emotracker

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.conlage.emotracker.navigation.Destination
import com.conlage.emotracker.navigation.EmoTrackerNavGraph
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun EmoTrackerApp() {

   EmoTrackerNavGraph(
      startDestination = Destination.Home.route,
      navController = rememberAnimatedNavController()
   )
}