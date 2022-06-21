package com.conlage.emotracker.navigation

sealed interface Destination {

   val name: String
   val route: String

   object Authorization : Destination {
      override val name: String get() = "Вход"
      override val route: String get() = "auth"
   }

   object Registration : Destination {
      override val name: String get() = "Регистрация"
      override val route: String get() = "register"
   }

   object Home : Destination {
      override val name: String get() = "Главная"
      override val route: String get() = "home"
   }
}