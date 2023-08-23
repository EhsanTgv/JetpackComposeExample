package com.taghavi.jetpackcomposeexample.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.core.colors

class ProcessDeathActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TitleComponent("Enter your credit card number below")
                ProcessDeathComponent()
            }
        }
    }
}

@Composable
fun ProcessDeathComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .width(300.dp)
                .aspectRatio(16 / 9f),
            backgroundColor = colors[0]
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                var textValue by rememberSaveable { mutableStateOf("") }
                TextField(
                    value = TextFieldValue(textValue),
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Serif,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    visualTransformation = CreditCardVisualTransformation(),
                    onValueChange = { newTextValue ->
                        textValue = newTextValue.text
                    },
                )
                Text(
                    text = "Ehsan Taghavi",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }
        }
    }
}

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            AnnotatedString(text.text.replace("....".toRegex(), "$0 ")),
            creditCardOffsetMap
        )
    }
}

val creditCardOffsetMap = object : OffsetMapping {
    override fun originalToTransformed(offset: Int) = offset + (offset / 4)
    override fun transformedToOriginal(offset: Int) = offset - (offset / 4)
}

@Composable
fun TitleComponent(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.W900,
            fontSize = 14.sp,
            color = Color.Black,
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun ProcessDeathComponentPreview() {
    ProcessDeathComponent()
}