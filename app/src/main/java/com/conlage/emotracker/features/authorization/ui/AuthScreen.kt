package com.conlage.emotracker.features.authorization.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.conlage.emotracker.components.OutlinedTextFiledWithIcon
import com.conlage.emotracker.theme.AppTheme
import com.conlage.emotracker.R
import com.conlage.emotracker.components.Button
import com.conlage.emotracker.navigation.Destination
import com.conlage.emotracker.theme.Mont

@Composable
fun AuthScreen(
   uiState: AuthUiState,
   authorize: () -> Unit,
   onEmailChanged: (email: String) -> Unit,
   onPasswordChanged: (password: String) -> Unit,
   navigateToRegistration: () -> Unit
) {

   Column(
      modifier = Modifier
         .fillMaxSize(1f)
         .background(AppTheme.colors.mainColor)
         .padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
   ) {

      Spacer(modifier = Modifier.weight(1f))
      Text(
         text = Destination.Authorization.name,
         style = AppTheme.typography.topBarTitle.copy(fontSize = 24.sp),
         color = Color.White
      )
      OutlinedTextFiledWithIcon(
         modifier = Modifier.fillMaxWidth(1f),
         textValue = uiState.email,
         onValueChanged = onEmailChanged,
         label = "E-Mail",
         placeholder = "example@mail.ru",
         icon = R.drawable.ic_email
      )
      OutlinedTextFiledWithIcon(
         modifier = Modifier.fillMaxWidth(1f),
         textValue = uiState.password,
         onValueChanged = onPasswordChanged,
         label = "Пароль",
         placeholder = "********",
         icon = R.drawable.ic_password
      )
      Spacer(modifier = Modifier.height(16.dp))
      Button(
         text = "Войти",
         backgroundColor = Color.White,
         textColor = AppTheme.colors.mainColor,
         onClick = authorize
      )
      Spacer(modifier = Modifier)
      Text(
         text = "Создать новый аккаунт",
         fontFamily = Mont,
         color = Color.White,
         modifier = Modifier
            .align(CenterHorizontally)
            .clickable { navigateToRegistration() }
      )
   }
}