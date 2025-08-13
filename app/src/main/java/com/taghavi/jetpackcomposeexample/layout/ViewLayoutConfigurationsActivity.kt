package com.taghavi.jetpackcomposeexample.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.state.TitleComponent

class ViewLayoutConfigurationsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                item {
                    TitleComponent("Child views with equal weights")
                    RowEqualWeightComponent()
                }
                item {
                    TitleComponent("Child views with unequal weights")
                    RowUnequalWeightComponent()
                }
                item {
                    TitleComponent("Child view with auto space in between")
                    RowAddSpaceBetweenViewsComponent()
                }
                item {
                    TitleComponent("Child views spaced evenly")
                    RowSpaceViewsEvenlyComponent()
                }
                item {
                    TitleComponent("Space added around child views")
                    RowSpaceAroundViewsComponent()
                }
                item {
                    TitleComponent("Child views centered")
                    RowViewsCenteredComponent()
                }
                item {
                    TitleComponent("Child views arranged in end")
                    RowViewsArrangedInEndComponent()
                }
                item {
                    TitleComponent("Baseline of child views aligned")
                    RowBaselineAlignComponent()
                }
                item {
                    TitleComponent("Baseline of child views not aligned")
                    RowBaselineUnalignedComponent()
                }
            }
        }
    }
}

@Composable
fun RowEqualWeightComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            onClick = {}
        ) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(
            modifier = Modifier
                .weight(1f)
                .padding(4.dp),
            onClick = {},
        ) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun RowUnequalWeightComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            modifier = Modifier
                .weight(0.66f)
                .padding(4.dp),
            onClick = {}
        ) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(
            modifier = Modifier
                .weight(0.33f)
                .padding(4.dp),
            onClick = {},
        ) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun RowAddSpaceBetweenViewsComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun RowSpaceViewsEvenlyComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }

    }
}

@Composable
fun RowSpaceAroundViewsComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun RowViewsCenteredComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }

    }
}

@Composable
fun RowViewsArrangedInEndComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Button(onClick = {}) {
            Text(
                text = "Button 1",
                style = TextStyle(fontSize = 20.sp)
            )
        }
        Button(onClick = {}) {
            Text(
                text = "Button 2",
                style = TextStyle(fontSize = 20.sp)
            )
        }
    }
}

@Composable
fun RowBaselineAlignComponent(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()){
        Text(
            text = "Text 1",
            style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic),
            modifier = Modifier.alignBy(alignmentLine = FirstBaseline)
        )
        Text(
            text = "Text 2",
            style = TextStyle(
                fontSize = 40.sp, fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.alignBy(alignmentLine = FirstBaseline)
        )
    }
}

@Composable
fun RowBaselineUnalignedComponent() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Text 1",
            style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
        )
        Text(
            text = "Text 2",
            style = TextStyle(
                fontSize = 40.sp, fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview("Child views with equal weights")
@Composable
fun RowEqualWeightComponentPreview() {
    RowEqualWeightComponent()
}

@Preview("Child views with unequal weights")
@Composable
fun RowUnequalWeightComponentPreview() {
    RowUnequalWeightComponent()
}

@Preview("Child view with auto space in between arrangement")
@Composable
fun RowAddSpaceBetweenViewsComponentPreview() {
    RowAddSpaceBetweenViewsComponent()
}

@Preview("Child views spaced evenly arrangement")
@Composable
fun RowSpaceViewsEvenlyComponentPreview() {
    RowSpaceViewsEvenlyComponent()
}

@Preview("Space added around child views arrangement")
@Composable
fun RowSpaceAroundViewsComponentPreview() {
    RowSpaceAroundViewsComponent()
}

@Preview("Child views centered arrangement")
@Composable
fun RowViewsCenteredComponentPreview() {
    RowViewsCenteredComponent()
}

@Preview("Child views arranged in end")
@Composable
fun RowViewsArrangedInEndComponentPreview() {
    RowViewsArrangedInEndComponent()
}

@Preview("Baseline of child views aligned")
@Composable
fun RowBaselineAlignComponentPreview() {
    RowBaselineAlignComponent()
}

@Preview("Baseline of child views not aligned")
@Composable
fun RowBaselineUnalignedComponentPreview() {
    RowBaselineUnalignedComponent()
}