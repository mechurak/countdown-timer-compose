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
package com.example.androiddevchallenge

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class TimerViewModel : ViewModel() {
    private var timer: CountDownTimer? = null

    var counting by mutableStateOf(false)
    fun onReset() {
        counting = false
        timer?.cancel()
    }

    fun onStart(value: Int) {
        Log.i("SHIM", "onStart($value)")
        count = value
        counting = true

        timer = object : CountDownTimer(count * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                Log.i("SHIM", "onTick($millisUntilFinished)")
                count = (millisUntilFinished / 1000f).roundToInt()
            }

            override fun onFinish() {
                Log.i("SHIM", "onFinish()")
                count = 0
            }
        }.start()
    }

    var count by mutableStateOf(20)
    fun onCountChanged(value: Int) {
        count = value
    }
}
