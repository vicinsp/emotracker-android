package com.conlage.emotracker.theme

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalEmoTrackerColors = staticCompositionLocalOf<Colors> { error("no default colors") }
internal val LocalEmoTrackerTypography =
   staticCompositionLocalOf<Typography> { error("no default colors") }

object RippleTheme : RippleTheme {
   @Composable
   override fun defaultColor() =
      RippleTheme.defaultRippleColor(
         Color(0x8F281542),
         lightTheme = true
      )

   @Composable
   override fun rippleAlpha(): RippleAlpha =
      RippleTheme.defaultRippleAlpha(
         Color(0x8F281542),
         lightTheme = true
      )
}

object AppTheme {
   val colors: Colors
      @Composable
      @ReadOnlyComposable
      get() = LocalEmoTrackerColors.current

   val typography: Typography
      @Composable
      @ReadOnlyComposable
      get() = LocalEmoTrackerTypography.current
}

@Composable
fun EmoTrackerTheme(content: @Composable () -> Unit) {
   MaterialTheme() {
      CompositionLocalProvider(
         values = arrayOf(
            LocalEmoTrackerColors provides colorPalette,
            LocalEmoTrackerTypography provides typography,
            LocalRippleTheme provides com.conlage.emotracker.theme.RippleTheme,
            LocalTextStyle provides typography.partition
         ),
         content = content
      )
   }

}