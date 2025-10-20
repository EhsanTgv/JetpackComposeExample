package com.taghavi.jetpackcomposeexample.interop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.R
import com.taghavi.jetpackcomposeexample.core.colors

class ComposeInClassicAndroidActivity : AppCompatActivity() {
    private lateinit var containerLayout: ComposeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compose_in_classic_android)
        containerLayout = findViewById(R.id.compose_view)

        containerLayout.setContent {
            CardComponentWithMessage()
        }
    }
}

@Composable
fun CardComponentWithMessage() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = colors[1]
            ),
        ) {
            Text(
                "This is an example of a Jetpack Compose composable inside a classic Android view",
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
    }
}

@Preview
@Composable
private fun CardComponentWithMessagePreview() {
    CardComponentWithMessage()
}