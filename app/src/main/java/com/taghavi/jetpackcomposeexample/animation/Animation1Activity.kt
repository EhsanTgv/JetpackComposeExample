package com.taghavi.jetpackcomposeexample.animation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Animation1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RotatingSquareComponent()
        }
    }
}

@Composable
fun RotatingSquareComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            val infiniteTransition = rememberInfiniteTransition()

            val rotation by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween<Float>(
                        durationMillis = 3000,
                        easing = FastOutLinearInEasing
                    )
                )
            )

            Canvas(modifier = Modifier.size(200.dp)) {
                rotate(rotation) {
                    drawRect(color = Color(255, 138, 128))
                }
            }
        }
    )
}

@Preview
@Composable
fun RotatingSquareComponentPreview() {
    RotatingSquareComponent()
}