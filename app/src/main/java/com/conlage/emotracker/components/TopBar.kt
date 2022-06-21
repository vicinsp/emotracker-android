package com.conlage.emotracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.conlage.emotracker.R
import com.conlage.emotracker.theme.AppTheme

@Composable
fun TopBar(
   title: String,
   trailingIcon: @Composable BoxScope.() -> Unit? = {},
   withBackArrow: Boolean = false,
   isLoading: Boolean = false,
   onClickBack: () -> Unit = {},
   onClickTrailingIcon: () -> Unit = {}
) {

   Box(
      Modifier
         .height(56.dp)
         .background(Color.White),
      contentAlignment = Alignment.CenterStart
   ) {

      TopBarTitle(title = title)

      if (withBackArrow)
         TopBarBackArrow(onClick = onClickBack)

      if (isLoading)
         LoadingBar(modifier = Modifier.align(Alignment.BottomCenter))

      Box(
         modifier = Modifier
            .align(Alignment.CenterEnd)
            .padding(end = 16.dp)
            .clickable(
               interactionSource = remember { MutableInteractionSource() },
               indication = null,
               onClick = onClickTrailingIcon
            ),
         content = { trailingIcon() }
      )
   }
}

@Composable
private fun TopBarTitle(title: String) {
   Text(
      text = title,
      style = AppTheme.typography.topBarTitle,
      modifier = Modifier
         .fillMaxWidth(1f)
         .padding(horizontal = 56.dp),
      textAlign = TextAlign.Center,
      color = AppTheme.colors.mainColor
   )
}

@Composable
private fun TopBarBackArrow(onClick: () -> Unit) {
   Icon(
      painter = painterResource(id = R.drawable.ic_back_arrow),
      tint = AppTheme.colors.mainColor,
      contentDescription = null,
      modifier = Modifier
         .offset(x = (-4).dp)
         .clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
         )
         .size(56.dp)
         .padding(18.dp)
   )
}