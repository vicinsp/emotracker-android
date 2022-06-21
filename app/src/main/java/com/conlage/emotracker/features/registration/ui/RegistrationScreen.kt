package com.conlage.emotracker.features.registration.ui

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
fun RegistrationScreen(
   uiState: RegistrationUiState,
   authorize: () -> Unit,
   onNameChanged: (name: String) -> Unit,
   onEmailChanged: (email: String) -> Unit,
   onPasswordChanged: (password: String) -> Unit,
   onPassword2Changed: (password2: String) -> Unit,
   navigateToAuthorization: () -> Unit
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
         text = Destination.Registration.name,
         style = AppTheme.typography.topBarTitle.copy(fontSize = 24.sp),
         color = Color.White
      )
      OutlinedTextFiledWithIcon(
         modifier = Modifier.fillMaxWidth(1f),
         textValue = uiState.name,
         onValueChanged = onNameChanged,
         label = "Имя",
         placeholder = "Иван",
         icon = R.drawable.ic_email
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
      OutlinedTextFiledWithIcon(
         modifier = Modifier.fillMaxWidth(1f),
         textValue = uiState.password2,
         onValueChanged = onPassword2Changed,
         label = "Пароль (подтвердить)",
         placeholder = "********",
         icon = R.drawable.ic_password
      )
      Spacer(modifier = Modifier.height(16.dp))
      Button(
         text = "Создать аккаунт",
         backgroundColor = Color.White,
         textColor = AppTheme.colors.mainColor,
         onClick = authorize
      )
      Spacer(modifier = Modifier)
      Text(
         text = "Уже есть аккаунт? Войти",
         color = Color.White,
         fontFamily = Mont,
         modifier = Modifier
            .align(CenterHorizontally)
            .clickable{ navigateToAuthorization() }
      )
   }
}