/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AnimationText(text: String) {
    val alphaValue = remember { Animatable(1.0f) }

    LaunchedEffect(text) {
        alphaValue.animateTo(
            targetValue = 0.0f,
            animationSpec = keyframes {
                durationMillis = 500
                0.0f at 0 with LinearOutSlowInEasing
                1.0f at 30
                0.9f at 60 with FastOutSlowInEasing
            }
        )
    }

    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h2
    )
    Text(
        text = text,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onSurface.copy(alpha = alphaValue.value),
        modifier = Modifier.scale((1.0f - 2.5f) / 1.0f * alphaValue.value + 2.5f)
    )
}

@Preview
@Composable
fun AnimationTextPreview() {
    MyTheme {
        AnimationText("10")
    }
}
