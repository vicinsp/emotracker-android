package com.conlage.emotracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.conlage.emotracker.theme.AppTheme
import com.conlage.emotracker.theme.Mont

@Composable
fun Button(
   modifier: Modifier = Modifier,
   text: String,
   enabled: Boolean = true,
   backgroundColor: Color = AppTheme.colors.mainColor,
   textColor: Color = Color.White,
   onClick: () -> Unit,
) {

   val alpha = if (enabled) 1f else 0.3f

   Surface(shape = RoundedCornerShape(18.dp), modifier = modifier) {
      Box(
         modifier = Modifier
            .fillMaxWidth(1f)
            .height(48.dp)
            .background(backgroundColor.copy(alpha = alpha), RoundedCornerShape(18.dp))
            .clickable(enabled = enabled, onClick = onClick),
         contentAlignment = Alignment.Center
      ) {

         Text(
            text = text,
            color = textColor,
            style = AppTheme.typography.buttonText,
         )
      }
   }
}