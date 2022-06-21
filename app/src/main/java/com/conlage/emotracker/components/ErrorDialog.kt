package com.conlage.emotracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.conlage.emotracker.theme.AppTheme

@Composable
fun ErrorDialog(
   title: String = "Ошибка",
   message: String?,
   onDismiss: () -> Unit
) {
   message?.let {
      Dialog(
         onDismissRequest = onDismiss,
         content = {
            Column(
               modifier = Modifier
                  .fillMaxWidth(1f)
                  .background(Color.White, RoundedCornerShape(16.dp)),
            ) {
               Spacer(modifier = Modifier.height(16.dp))
               Text(
                  text = title,
                  Modifier.padding(horizontal = 16.dp),
                  fontWeight = FontWeight.Bold,
                  fontSize = 18.sp,
                  color = AppTheme.colors.mainColor
               )
               Spacer(modifier = Modifier.height(12.dp))
               Spacer(modifier = Modifier.height(16.dp))
               Text(
                  text = message,
                  Modifier.padding(horizontal = 16.dp),
                  fontSize = 15.sp,
                  lineHeight = 21.sp
               )
               Spacer(modifier = Modifier.height(24.dp))

               Row(Modifier.align(Alignment.End)) {

                  Text(
                     text = "ОК",
                     fontWeight = FontWeight.Bold,
                     fontSize = 15.sp,
                     color = AppTheme.colors.mainColor,
                     modifier = Modifier
                        .clickable(
                           interactionSource = remember { MutableInteractionSource() },
                           indication = null
                        ) { onDismiss() }
                        .padding(start = 16.dp, end = 16.dp)
                  )
               }
               Spacer(modifier = Modifier.height(16.dp))
            }
         },
         properties = DialogProperties()
      )
   }
}
