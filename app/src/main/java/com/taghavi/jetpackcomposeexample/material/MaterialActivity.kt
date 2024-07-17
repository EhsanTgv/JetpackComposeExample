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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Slider
import androidx.compose.material.Snackbar
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
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
                item {
                    TitleComponent(title = "This is a material Snackbar")
                    MaterialSnackbarComponent()
                }
                item {
                    TitleComponent(title = "this is a non-discrete slider")
                    MaterialContinousSliderComponent()
                }
                item {
                    TitleComponent(title = "this is a discrete slider")
                    MaterialDiscreteSliderComponent()
                }
                item {
                    TitleComponent(title = "This is a checkbox that represents two states")
                    MaterialCheckboxComponent()
                }
                item {
                    TitleComponent(title = "This is a checkbox that represent three state")
                    MaterialTriStateCheckboxComponent()
                }
                item {
                    TitleComponent(title = "This is a radio button")
                    MaterialRadioButtonComponent()
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

@Composable
fun MaterialSnackbarComponent() {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Snackbar(
            content = {
                Text(text = "This is a snackbar")
            },
            action = {
                Text(text = "Okay", style = TextStyle(color = MaterialTheme.colorScheme.secondary))
            }
        )
    }
}

@Composable
fun MaterialContinousSliderComponent() {
    var sliderValue by remember { mutableFloatStateOf(0f) }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.padding(8.dp),
    ) {
        Slider(value = sliderValue, onValueChange = { newValue ->
            sliderValue = newValue
        })
    }
}

@Composable
fun MaterialDiscreteSliderComponent() {
    var sliderValue by remember { mutableFloatStateOf(0f) }

    Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
        Slider(
            value = sliderValue,
            valueRange = 0f..10f,
            steps = 8,
            onValueChange = { newValue ->
                sliderValue = newValue
            },
        )
    }

    Text(
        text = "Slider value is %.1f".format(sliderValue),
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun MaterialCheckboxComponent() {
    var checked by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Checkbox(
                checked = checked,
                onCheckedChange = { checked = !checked }
            )
            Text(text = "Use Jetpack Compose", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun MaterialTriStateCheckboxComponent() {
    val toggleableStateArray = listOf(
        ToggleableState.Off,
        ToggleableState.On,
        ToggleableState.Indeterminate
    )

    var counter by remember { mutableStateOf(0) }

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
    {
        Row(modifier = Modifier.padding(16.dp)) {
            TriStateCheckbox(
                state = toggleableStateArray[counter % 3],
                onClick = {
                    counter++
                }
            )
            Text(text = "Use Jetpack Compose", modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Composable
fun MaterialRadioButtonComponent() {
    var selected by remember { mutableStateOf("Android") }

    val radioGroupOptions = listOf("Android", "iOS", "Windows")

    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        val onSelectedChange = { text: String ->
            selected = text
        }
        Column {
            radioGroupOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (selected == text),
                            onClick = { onSelectedChange(text) }
                        )
                ) {
                    RadioButton(
                        selected = (selected == text),
                        onClick = { onSelectedChange(text) }
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}