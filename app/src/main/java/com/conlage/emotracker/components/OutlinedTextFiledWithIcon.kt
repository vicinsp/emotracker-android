package com.conlage.emotracker.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.theme.AppTheme

@Composable
fun OutlinedTextFiledWithIcon(
   modifier: Modifier = Modifier,
   textValue: String,
   onValueChanged: (newValue: String) -> Unit,
   label: String,
   placeholder: String,
   @DrawableRes
   icon: Int,
   keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
   visualTransformation: VisualTransformation = VisualTransformation.None,
) {

   OutlinedTextField(
      colors = TextFieldDefaults.outlinedTextFieldColors(
         trailingIconColor = Color.White,
         textColor = Color.White,
         placeholderColor = Color.White.copy(0.7f),
         focusedBorderColor = Color.White,
         unfocusedBorderColor = Color.White,
         focusedLabelColor = Color.White,
         unfocusedLabelColor = Color.White.copy(0.7f),
         cursorColor = Color.White
      ),
      shape = RoundedCornerShape(12.dp),
      modifier = modifier,
      value = textValue,
      onValueChange = onValueChanged,
      keyboardOptions = keyboardOptions,
      textStyle = AppTheme.typography.textFiled,
      label = {
         Text(text = label, style = AppTheme.typography.textFiled)
      },
      singleLine = true,
      placeholder = {
         Text(text = placeholder, style = AppTheme.typography.textFiled)
      },
      trailingIcon = {
         Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
         )
      },
      visualTransformation = visualTransformation
   )
}