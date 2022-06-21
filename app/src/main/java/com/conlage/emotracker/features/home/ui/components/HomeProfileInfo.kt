package com.conlage.emotracker.features.home.ui.components

import androidx.compose.foundation.background
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
fun HomeProfileInfo(userName: String, email: String, onClick: () -> Unit) {
   Surface(
      shape = RoundedCornerShape(24.dp), modifier = Modifier.padding(horizontal = 16.dp)
   ) {
      Row(
         Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .background(AppTheme.colors.lightGrayBgColor)
            .padding(horizontal = 16.dp, vertical = 16.dp)) {
         CircleImage(size = 64.dp, painter = painterResource(id = R.drawable.ic_password))
         Spacer(modifier = Modifier.width(16.dp))
         Column(
            Modifier.align(Alignment.CenterVertically),
         ) {
            Text(
               text = userName,
               fontSize = 18.sp,
               fontWeight = FontWeight.Bold,
            )
            Text(
               text = email,
               fontSize = 14.sp,
               color = AppTheme.colors.mainColor,
            )
         }
      }
   }
}