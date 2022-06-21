package com.conlage.emotracker.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LoadingBar(modifier: Modifier = Modifier) {
    val color = remember { androidx.compose.animation.Animatable(Color(103, 89, 182, 255)) }
    val color2 = Color(234, 230, 255, 255)

    LaunchedEffect(Unit) {
        color.animateTo(
            color2, animationSpec = infiniteRepeatable(
                tween(durationMillis = 1000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    LinearProgressIndicator(
        color = color.value,
        backgroundColor = color.value.copy(alpha = 0.3f),
        modifier = modifier
            .fillMaxWidth(1f)
            .height(3.dp)
    )
}