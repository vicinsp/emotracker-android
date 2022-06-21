package com.conlage.emotracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.theme.AppTheme

@Composable
fun CircleImage(
   size: Dp,
   painter: Painter,
   enabled: Boolean = false,
   onClick: () -> Unit = {}
) {
   val modifierClick: Modifier = if (!enabled) Modifier else Modifier.clickable { onClick() }
   Surface(
      shape = CircleShape,
   ) {
      Icon(
         tint = AppTheme.colors.mainColor,
         painter = painter,
         contentDescription = "",
         modifier = Modifier
            .size(size)
            .background(Color(241, 239, 245, 255))
            .padding(16.dp)
            .then(modifierClick),
      )
   }
}