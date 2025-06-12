package com.taghavi.jetpackcomposeexample.scrollers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.core.Person
import com.taghavi.jetpackcomposeexample.core.colors
import com.taghavi.jetpackcomposeexample.core.getPersonList
import com.taghavi.jetpackcomposeexample.state.TitleComponent

class HorizontalScrollableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                TitleComponent("Horizontal Scrollable Carousel")
                HorizontalScrollableComponent(getPersonList())

                TitleComponent("Horizontal Scrolling Carousel where each item occupies the width of the screen")
                HorizontalScrollableComponentWithScreenWidth(getPersonList())
            }
        }
    }
}

@Composable
fun HorizontalScrollableComponent(personList: List<Person>) {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(
                state = scrollState,
            ),
        content = {
            for ((index, person) in personList.withIndex()) {
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = colors[index % colors.size],
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        person.name,
                        modifier = Modifier.padding(16.dp),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 20.sp,
                        )
                    )
                }
            }
        }
    )
}

@Composable
fun HorizontalScrollableComponentWithScreenWidth(personList: List<Person>) {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(
                state = scrollState,
            ),
        content = {

            val context = LocalContext.current
            val resources = context.resources
            val displayMetrics = resources.displayMetrics

            val screenWidth = displayMetrics.widthPixels / displayMetrics.density
            val spacing = 16.dp

            Row {
                for ((index, person) in personList.withIndex()) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        backgroundColor = colors[index % colors.size],
                        modifier = Modifier.padding(spacing),
                    ) {
                        Column(
                            modifier = Modifier.width(screenWidth.dp - (spacing * 2)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(
                                person.name,
                                modifier = Modifier.padding(16.dp),
                                style = TextStyle(
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                )
                            )
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun HorizontalScrollableComponentPreview() {
    HorizontalScrollableComponent(
        getPersonList()
    )
}

@Preview
@Composable
private fun HorizontalScrollableComponentWithScreenWidthPreview() {
    HorizontalScrollableComponentWithScreenWidth(
        getPersonList()
    )
}