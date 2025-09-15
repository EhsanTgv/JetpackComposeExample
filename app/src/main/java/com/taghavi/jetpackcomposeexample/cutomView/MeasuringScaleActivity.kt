package com.taghavi.jetpackcomposeexample.cutomView

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MeasuringScaleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {
                MeasuringScaleComponent()
            }
        }
    }
}

@Composable
fun MeasuringScaleComponent() {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .padding(top = 16.dp)
            .fillMaxWidth(),
        content = {
            for (i in -20..1020) {
                ScaleLineComponent(i)
            }
        }
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ) {
        ScaleCenterPointer()
    }
}

@Composable
fun ScaleLineComponent(index: Int) {
    val isDivisibleBy10 = index % 10 == 0

    val surfaceColor = MaterialTheme.colors.surface

    val onSurfaceColor = MaterialTheme.colors.onSurface

    Column(modifier = Modifier.background(color = surfaceColor)) {
        Canvas(
            modifier = Modifier
                .padding(5.dp)
                .height(100.dp)
                .width(3.dp)
        ) {
            drawLine(
                color = onSurfaceColor,
                start = Offset(0f, 0f),
                end = Offset(0f, if (isDivisibleBy10) size.height else size.height * 0.2f),
                strokeWidth = if (isDivisibleBy10) size.width else size.width * 0.3f
            )
        }

        Text(
            text = if (isDivisibleBy10) "${index / 10}" else "",
            textAlign = TextAlign.Center,
            style = TextStyle(fontFamily = FontFamily.Monospace),
            color = onSurfaceColor,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun ScaleCenterPointer() {
    val primaryColor = MaterialTheme.colors.primary

    Column {
        Canvas(
            modifier = Modifier
                .padding(5.dp)
                .height(120.dp)
                .width(3.dp)
        ) {
            drawLine(
                color = primaryColor,
                start = Offset(0f, 0f),
                end = Offset(0f, size.height),
                strokeWidth = size.width,
            )
        }
    }
}

@Composable
fun CustomTheme(children: @Composable () -> Unit) {
    val lightColors = lightColors()
    val darkColors = darkColors()

    val color = if (isSystemInDarkTheme()) darkColors else lightColors

    MaterialTheme(colors = color) {
        children()
    }
}


@Preview
@Composable
fun MeasuringScaleComponentPreview() {
    CustomTheme {
        MeasuringScaleComponent()
    }
}