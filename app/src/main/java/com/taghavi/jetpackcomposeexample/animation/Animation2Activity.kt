package com.taghavi.jetpackcomposeexample.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class Animation2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimateColorComponent()
        }
    }
}

@Composable
fun AnimateColorComponent() {
    val currentColor = remember { MutableTransitionState(Color.Red) }
    val label = "Color Animation"

    val transition = updateTransition(currentColor, label)

    val color by transition.animateColor(
        transitionSpec = { tween(durationMillis = 2000) },
        label = label,
        targetValueByState = { it }
    )

    LaunchedEffect(key1 = currentColor.currentState) {
        currentColor.targetState = when (currentColor.currentState) {
            Color.Red -> Color.Green
            Color.Green -> Color.Blue
            Color.Blue -> Color.Cyan
            Color.Cyan -> Color.Magenta
            else -> Color.Green
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = color)
    ) {

    }
}

@Preview
@Composable
fun AnimateColorComponentPreview() {
    AnimateColorComponent()
}