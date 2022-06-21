package com.conlage.emotracker.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.conlage.emotracker.R

val Mont = FontFamily(
   Font(R.font.mont_black, FontWeight.Black),
   Font(R.font.mont_heavy, FontWeight.ExtraBold),
   Font(R.font.mont_bold, FontWeight.Bold),
   Font(R.font.mont_semibold, FontWeight.SemiBold),
   Font(R.font.mont_regular, FontWeight.Normal),
   Font(R.font.mont_light, FontWeight.Light),
)

data class Typography(
   val topBarTitle: TextStyle,
   val bottomSheetTitle: TextStyle,
   val buttonText: TextStyle,
   val partition: TextStyle,
   val textFiled: TextStyle,
)

val typography = Typography(
   topBarTitle = TextStyle(
      fontFamily = Mont,
      fontWeight = FontWeight.ExtraBold,
      fontSize = 21.sp,
   ),
   bottomSheetTitle = TextStyle(
      fontFamily = Mont,
      fontWeight = FontWeight.Black,
      fontSize = 18.sp,
   ),
   buttonText = TextStyle(
      fontFamily = Mont,
      fontWeight = FontWeight.Bold,
      fontSize = 16.sp,
   ),
   partition = TextStyle(
      fontFamily = Mont,
      fontWeight = FontWeight.Normal,
      fontSize = 14.sp,
   ),
   textFiled = TextStyle(
      fontFamily = Mont,
      fontWeight = FontWeight.SemiBold,
      fontSize = 16.sp,
   )
)
