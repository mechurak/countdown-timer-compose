package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Separator(count: Int) {
    val alphaValue = remember { Animatable(1.0f) }

    LaunchedEffect(count) {
        alphaValue.animateTo(
            targetValue = 0.05f,
            animationSpec = keyframes {
                durationMillis = 900
                0.0f at 0 with LinearOutSlowInEasing
                1.0f at 30
                1.0f at 500 with FastOutLinearInEasing
            }
        )
    }

    Text(
        text = ":",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onSurface.copy(alpha = alphaValue.value),
    )
}