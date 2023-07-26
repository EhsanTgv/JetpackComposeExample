package com.taghavi.jetpackcomposeexample.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class StateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxWidth()) {
                StateComponent()
                Divider()
                ModelComponent()
            }
        }
    }

    @Composable
    fun StateComponent() {
        var counter by remember { mutableStateOf(0) }
        TitleComponent("Example using state class to store state")
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                onClick = {
                    counter++
                }
            ) {
                Text(text = "Increment", modifier = Modifier.padding(16.dp))
            }

            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                onClick = {
                    counter = 0
                }
            ) {
                Text(text = "Reset", modifier = Modifier.padding(16.dp))
            }
        }
        Text(text = "Counter value is $counter", modifier = Modifier.padding(16.dp))
    }

    @Composable
    fun ModelComponent() {
        var counterState by remember { mutableStateOf(CounterState()) }
        TitleComponent(title = "Example using Model class to store state")

        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                onClick = {
                    counterState = counterState.copy(counter = counterState.counter + 1)
                }
            ) {
                Text(text = "Increment", modifier = Modifier.padding(16.dp))
            }

            Button(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                onClick = {
                    counterState = counterState.copy(counter = 0)
                }
            ) {
                Text(text = "Reset", modifier = Modifier.padding(16.dp))
            }
        }
        Text(text = "Counter value is ${counterState.counter}", modifier = Modifier.padding(16.dp))
    }

    @Composable
    fun TitleComponent(title: String) {
        // Text is a predefined composable that does exactly what you'd expect it to - display text on
        // the screen. It allows you to customize its appearance using style, fontWeight, fontSize, etc.
        Text(
            title, style = TextStyle(
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.W900,
                fontSize = 14.sp, color = Color.Black
            ), modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
    }

    data class CounterState(val counter: Int = 0)
}