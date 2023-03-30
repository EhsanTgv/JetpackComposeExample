package com.taghavi.jetpackcomposeexample.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.taghavi.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class SimpleTextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleText("This is the Learn Jetpack Compose By Example tutorial")
            }
        }
    }
}

@Composable
fun SimpleText(displayText: String) {
    Text(text = displayText)
}

@Preview()
@Composable
fun SimpleTextPreview() {
    SimpleText("This is the Learn Jetpack Compose By Example tutorial")
}