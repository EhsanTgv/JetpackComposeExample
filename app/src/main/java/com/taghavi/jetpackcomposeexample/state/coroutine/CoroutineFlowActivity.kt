package com.taghavi.jetpackcomposeexample.state.coroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CoroutineFlowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlowComponent(countdownFlow())
        }
    }
}

@Composable
fun FlowComponent(flow: Flow<Int>) {
    val countDownValue by flow.collectAsState(initial = 10)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (countDownValue) {
            in 1..10 -> {
                CountdownText("Countdown: $countDownValue")
            }

            else -> {
                CountdownText("Happy New Year !!!", Color.Magenta)
            }
        }
    }
}

@Composable
fun CountdownText(text: String, color: Color = Color.Black) {
    Text(
        text = text,
        color = color,
        style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
        ),
    )
}

fun countdownFlow() = flow<Int> {
    for (i in 9 downTo 0) {
        delay(1000L)
        emit(i)
    }
}