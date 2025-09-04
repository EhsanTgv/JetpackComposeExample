package com.taghavi.jetpackcomposeexample.cutomView

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class CustomViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomViewComponent()
        }
    }
}

@Composable
fun CustomViewComponent() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color.Red,
            radius = 300f
        )
        drawCircle(
            color = Color.Green,
            radius = 200f
        )
        drawCircle(
            color = Color.Blue,
            radius = 100f
        )
    }
}

@Preview
@Composable
private fun CustomViewComponentPreview() {
    CustomViewComponent()
}