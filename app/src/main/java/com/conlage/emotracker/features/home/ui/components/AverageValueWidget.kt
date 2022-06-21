package com.conlage.emotracker.features.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.conlage.emotracker.components.CircleImage
import com.conlage.emotracker.theme.AppTheme
import com.conlage.emotracker.R

@Composable
fun AverageValueWidget(value: Float?) {
   Row(
      modifier = Modifier
         .padding(horizontal = 16.dp)
         .fillMaxWidth()
         .border(1.dp, Color.Black, RoundedCornerShape(16.dp))
         .padding(16.dp),
      verticalAlignment = Alignment.CenterVertically
   ) {
      Text(
         text = value?.toString()?.format("%.1f") ?: "--",
         style = AppTheme.typography.buttonText.copy(fontSize = 48.sp),
         modifier = Modifier.weight(1f)
      )
      Text(text = "\uD83D\uDE27", fontSize = 48.sp)
   }
}