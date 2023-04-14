package com.taghavi.jetpackcomposeexample.stack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.taghavi.jetpackcomposeexample.R

class StackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackComponent()
        }
    }
}

@Composable
fun StackComponent() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        LocalResourceImageComponent(resId = R.drawable.landscape)

        Surface(color = Color.Gray) {
            Text(
                "Title",
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W900,
                    fontSize = 14.sp,
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun LocalResourceImageComponent(@DrawableRes resId: Int) {
    val image = painterResource(resId)
    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .sizeIn(maxHeight = 200.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun StackComponentPreview() {
    StackComponent()
}