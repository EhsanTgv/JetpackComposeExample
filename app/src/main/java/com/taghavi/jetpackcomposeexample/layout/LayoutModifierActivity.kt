package com.taghavi.jetpackcomposeexample.layout

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.core.colors
import com.taghavi.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class LayoutModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                item { SamePaddingComponent() }
                item { CustomPaddingComponent() }
                item { OffsetComponent() }
                item { AspectRatioComponent() }
            }
        }
    }
}

@Composable
fun SamePaddingComponent() {
    Surface(color = colors[0]) {
        Text(
            text = "This text has equal padding of 16dp in all directions",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun CustomPaddingComponent() {
    Surface(color = colors[1]) {
        Text(
            text = "This text has 32dp start padding, 4dp end padding, 32dp top padding & 0dp bottom padding padding in each direction",
            modifier = Modifier.padding(start = 32.dp, end = 4.dp, top = 32.dp, bottom = 0.dp),
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun OffsetComponent() {
    Surface(color = colors[2], modifier = Modifier.offset(x = 8.dp, y = 8.dp)) {
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up modifying the size of the layout. Using offset instead ensures that the size of the layout retains its size.",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif)
        )
    }
}

@Composable
fun AspectRatioComponent() {
    Surface(
        color = colors[3],
        modifier = Modifier
            .aspectRatio(16 / 9f)
            .padding(16.dp),
    ) {
        Text(
            text = "This text is wrapped in a layout that has a fixed aspect ratio of 16/9",
            style = TextStyle(fontSize = 20.sp, fontFamily = FontFamily.Serif),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview("Example with same padding applied to a composable")
@Composable
fun SamePaddingComponentPreview() {
    Column {
        SamePaddingComponent()
    }
}

@Preview("Example with custom padding in each direction applied to a composable")
@Composable
fun CustomPaddingComponentPreview() {
    Column {
        CustomPaddingComponent()
    }
}

@Preview("Example using offsets to position the composable")
@Composable
fun OffsetComponentPreview() {
    Column {
        OffsetComponent()
    }
}

@Preview("Example showing how a fixed aspect ration is applied a composable")
@Composable
fun AspectRatioComponentPreview() {
    Column {
        AspectRatioComponent()
    }
}