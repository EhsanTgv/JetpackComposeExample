package com.taghavi.jetpackcomposeexample.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                SimpleButtonComponent()
                SimpleButtonWithBorderComponent()
                RoundedCornerButtonComponent()
                OutlinedButtonComponent()
                TextButtonComponent()
            }
        }
    }
}

@Composable
fun SimpleButtonComponent() {
    Button(
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
        onClick = {}
    ) {
        Text(text = "Simple Button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SimpleButtonWithBorderComponent() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
        border = BorderStroke(width = 5.dp, brush = SolidColor(Color.Black))
    ) {
        Text(text = "Simple Button With Border", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun RoundedCornerButtonComponent() {
    Button(
        onClick = {},
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(5.dp),
    ) {
        Text(text = "Rounded Corner Button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun OutlinedButtonComponent() {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.padding(16.dp),
    ) {
        Text(text = "Outlined Button", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun TextButtonComponent() {
    TextButton(
        onClick = {},
        modifier = Modifier.padding(16.dp),
    ) {
        Text(text = "Text Button", modifier = Modifier.padding(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun SimpleButtonComponentPreview() {
    Column {
        SimpleButtonComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleButtonWithBorderComponentPreview() {
    Column {
        SimpleButtonWithBorderComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun RoundedCornerButtonComponentPreview() {
    Column {
        RoundedCornerButtonComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedButtonComponentPreview() {
    Column {
        OutlinedButtonComponent()
    }
}

@Preview(showBackground = true)
@Composable
fun TextButtonComponentPreview() {
    Column {
        TextButtonComponent()
    }
}
