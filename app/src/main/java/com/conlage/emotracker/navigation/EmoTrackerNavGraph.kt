package com.conlage.emotracker.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.conlage.emotracker.features.authorization.ui.AuthRoute
import com.conlage.emotracker.features.home.ui.HomeRoute
import com.conlage.emotracker.features.registration.ui.RegistrationRoute
import com.google.accompanist.navigation.animation.AnimatedNavHost


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun EmoTrackerNavGraph(
   startDestination: String,
   navController: NavHostController,
) {
   AnimatedNavHost(
      navController = navController,
      startDestination = startDestination,
      modifier = Modifier.background(Color.White)
   ) {

      animatedComposable(route = Destination.Authorization.route) {
         AuthRoute(
            navigateToHomeRoute = { navController.navigate(Destination.Registration.route) },
            navigateToRegisterRoute = {
               navController.navigate(Destination.Registration.route) {
                  launchSingleTop = true
                  restoreState = true
                  popUpTo(startDestination) {
                     saveState = true
                  }
               }
            })
      }

      animatedComposable(route = Destination.Registration.route) {
         RegistrationRoute(
            navigateToHomeRoute = {},
            navigateToAuthRoute = {
               navController.navigate(Destination.Authorization.route) {
                  launchSingleTop = true
                  restoreState = true
                  popUpTo(startDestination) {
                     saveState = true
                  }
               }
            })
      }

      animatedComposable(route = Destination.Home.route) {
         HomeRoute()
      }
   }

}