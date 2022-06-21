package com.conlage.emotracker.features.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.R
import com.conlage.emotracker.theme.AppTheme

@Composable
fun WatchStatButton(onClick: () -> Unit) {
   Row(
      Modifier
         .padding(horizontal = 16.dp)
         .fillMaxWidth(1f)
         .clickable { onClick() }
         .background(AppTheme.colors.mainColor, RoundedCornerShape(16.dp))
         .padding(horizontal = 16.dp, vertical = 16.dp)
   ) {
      Icon(
         painter = painterResource(id = R.drawable.ic_password),
         contentDescription = null,
         modifier = Modifier
            .size(40.dp)
            .background(
               Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp)
            )
            .padding(8.dp),
         tint = Color.White
      )
      Spacer(modifier = Modifier.width(16.dp))
      Text(
         text = "Посмотреть статистику",
         style = AppTheme.typography.buttonText,
         color = Color.White,
         modifier = Modifier.align(Alignment.CenterVertically)
      )
   }
}