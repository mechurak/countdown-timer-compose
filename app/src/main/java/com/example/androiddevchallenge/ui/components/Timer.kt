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

import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Timer(count: Int, onReset: () -> Unit) {
    var min = (count / 60).toString()
    if (min.length == 1) {
        min = "0$min"
    }
    var sec = (count % 60).toString()
    if (sec.length == 1) {
        sec = "0$sec"
    }
    Log.i("SHIM", "min: $min, sec: $sec")

    var soundUri: Uri? = null
    when (count) {
        0 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_0)
        1 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_1)
        2 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_2)
        3 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_3)
        4 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_4)
        5 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_5)
        6 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_6)
        7 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_7)
        8 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_8)
        9 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_9)
        10 -> soundUri = Uri.parse("android.resource://com.example.androiddevchallenge/" + R.raw.number_10)
    }

    if (soundUri != null) {
        Log.i("SHIM", "soundURI: $soundUri")
        val player = MediaPlayer.create(LocalContext.current, soundUri)
        player.isLooping = false
        player.start()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(120.dp)
            ) {
                Text(
                    text = min,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h2,
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(30.dp)
                    .height(120.dp)
            ) {
                Separator(count)
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(100.dp)
                    .height(120.dp)
            ) {
                Text(
                    text = sec,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h2
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onReset() },
            modifier = Modifier.width(260.dp)
        ) {
            Text(
                text = "Reset",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun TimerPreview() {
    MyTheme {
        Timer(20) {}
    }
}
