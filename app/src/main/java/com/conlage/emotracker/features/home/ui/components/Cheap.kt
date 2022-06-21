package com.conlage.emotracker.features.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.theme.AppTheme

@Composable
fun Cheap(title: String, selected: Boolean, onClick: () -> Unit) {
   val textColor = if (selected) Color.White else AppTheme.colors.grayTextColor
   val bgColor = if (selected) AppTheme.colors.mainColor else AppTheme.colors.lightGrayBgColor
   Text(
      text = title,
      color = textColor,
      modifier = Modifier
         .background(bgColor, RoundedCornerShape(50))
         .clip(RoundedCornerShape(50))
         .clickable { onClick() }
         .padding(horizontal = 16.dp, vertical = 8.dp)
   )

}