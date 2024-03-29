package com.taghavi.jetpackcomposeexample.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.taghavi.jetpackcomposeexample.R
import com.taghavi.jetpackcomposeexample.state.TitleComponent

class MaterialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LazyColumn {
                item {
                    TitleComponent(title = "This is a simple Material Card")
                    MaterialCardComponent()
                }

                item {
                    TitleComponent(title = "This is a loading progress indicator")
                    MaterialLinearProgressIndicatorComponent()
                }

                item {
                    TitleComponent(title = "This is a determinate progress indicator")
                    MaterialDeterminateLinearProgressIndicatorComponent()
                }
                item {
                    TitleComponent(title = "This is a loading circular progress indicator")
                    MaterialCircularProgressIndicator()
                }
                item {
                    TitleComponent(title = "This is a determinate circular progress indicator")
                    MaterialDeterminateCircularProgressIndicatorComponent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MaterialCardComponent() {
    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        ListItem(
            text = {
                Text(text = "Title")
            },
            secondaryText = {
                Text(text = "Subtitle")
            },
            icon = {
                Column(
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.landscape),
                        contentDescription = "landscape"
                    )
                }
            }
        )
    }
}

@Composable
fun MaterialLinearProgressIndicatorComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator()
        }
    }
}

@Composable
fun MaterialDeterminateLinearProgressIndicatorComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            LinearProgressIndicator(progress = 0.3f)
        }
    }
}

@Composable
fun MaterialCircularProgressIndicator() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally))
    }
}

@Composable
fun MaterialDeterminateCircularProgressIndicatorComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CircularProgressIndicator(
            progress = 0.55f,
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}