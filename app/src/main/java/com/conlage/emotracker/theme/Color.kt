package com.conlage.emotracker.theme

import androidx.compose.ui.graphics.Color

val colorPalette = Colors(
   mainColor = Color(0XFF7154CB),
   greenChartColor = Color(0XFF60AF80),
   greenChartBgColor = Color(0XFFE5F3ED),
   redChartColor = Color(0XFFD94C51),
   redChartBgColor = Color(0XFFF5E3E3),
   lightGrayBgColor = Color(0XFFF9F9FC),
   grayTextColor = Color(0XFFB4B1BE),
   darkTextColor = Color(0XFF232323),
)

data class Colors(
   val mainColor: Color,
   val greenChartColor: Color,
   val greenChartBgColor: Color,
   val redChartColor: Color,
   val redChartBgColor: Color,
   val lightGrayBgColor: Color,
   val grayTextColor: Color,
   val darkTextColor: Color
)