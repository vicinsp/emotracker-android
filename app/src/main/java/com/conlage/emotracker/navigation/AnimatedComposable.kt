package com.conlage.emotracker.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.animatedComposable(
   route: String,
   arguments: List<NamedNavArgument> = emptyList(),
   inverse: Boolean = false,
   content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit,
) {
   val transition =
      if (inverse) AnimatedContentScope.SlideDirection.Right
      else AnimatedContentScope.SlideDirection.Left
   val popUpTransition =
      if (inverse) AnimatedContentScope.SlideDirection.Left
      else AnimatedContentScope.SlideDirection.Right

   this.composable(
      arguments = arguments,
      route = route,
      enterTransition = {
         slideIntoContainer(
            transition,
            animationSpec = tween(600, easing = FastOutSlowInEasing)
         )
      },
      exitTransition = {
         slideOutOfContainer(
            transition,
            animationSpec = tween(600, easing = FastOutSlowInEasing)
         )
      },
      popEnterTransition = {
         slideIntoContainer(
            popUpTransition,
            animationSpec = tween(600, easing = FastOutSlowInEasing)
         )
      },
      popExitTransition = {
         slideOutOfContainer(
            popUpTransition,
            animationSpec = tween(600, easing = FastOutSlowInEasing)
         )
      },
      content = content
   )
}