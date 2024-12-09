package com.taghavi.jetpackcomposeexample.text

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.core.hideKeyboard
import com.taghavi.jetpackcomposeexample.state.TitleComponent

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                TitleComponent("This is a Simple Text Input field")
                SimpleTextInputComponent()

                TitleComponent("This is a TextInput with custom text style")
                CustomStyleTextInputComponent()

                TitleComponent("This is a TextInput suitable for typing numbers")
                NumberTextInputComponent()

                TitleComponent("This is a search view created using TextInput")
                SearchImeActionInputComponent()

                TitleComponent("This is a TextInput that uses a Password Visual Transformation")
                PasswordVisualTransformationInputComponent()

                TitleComponent("This is a filled TextInput field based on Material Design")
                MaterialTextInputComponent()
            }
        }
    }
}

@Composable
fun SimpleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter you text here")) }

        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            onValueChange = {
                textValue = it
            }
        )
    }
}

@Composable
fun CustomStyleTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter you text here")) }

        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                color = Color.Blue,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
            ),
            onValueChange = {
                textValue = it
            }
        )
    }
}

@Composable
fun NumberTextInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf("123") }

        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            onValueChange = {
                textValue = it
            },
        )
    }
}

@Composable
fun SearchImeActionInputComponent() {
    val context = LocalContext.current

    Surface(
        color = Color.LightGray,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your search query here")) }

        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ),
            onValueChange = {
                textValue = it
            },
            keyboardActions = KeyboardActions(
                onSearch = {
                    hideKeyboard(context)
                }
            )
        )
    }
}

@Composable
fun PasswordVisualTransformationInputComponent() {
    Surface(color = Color.LightGray, modifier = Modifier.padding(16.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue("Enter your password here")) }

        BasicTextField(
            value = textValue,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {
                textValue = it
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )
    }
}

@Composable
fun MaterialTextInputComponent() {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textValue,
        onValueChange = {
            textValue = it
        },
        label = { Text("Enter Your Name") },
        placeholder = { Text(text = "John Doe") },
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    )
}

@InternalTextApi
@Preview
@Composable
fun SimpleTextInputComponentPreview() {
    SimpleTextInputComponent()
}

@InternalTextApi
@Preview
@Composable
fun CustomStyleTextInputComponentPreview() {
    CustomStyleTextInputComponent()
}

@InternalTextApi
@Preview
@Composable
fun NumberTextInputComponentPreview() {
    NumberTextInputComponent()
}

@InternalTextApi
@Preview
@Composable
fun SearchImeActionInputComponentPreview() {
    SearchImeActionInputComponent()
}

@InternalTextApi
@Preview
@Composable
fun PasswordVisualTransformationInputComponentPreview() {
    PasswordVisualTransformationInputComponent()
}

@Preview
@Composable
fun FilledTextInputComponentPreview() {
    MaterialTextInputComponent()
}