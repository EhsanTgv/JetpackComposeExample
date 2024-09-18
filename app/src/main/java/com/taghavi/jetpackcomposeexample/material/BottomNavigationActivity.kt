package com.taghavi.jetpackcomposeexample.material

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taghavi.jetpackcomposeexample.state.TitleComponent

class BottomNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                TitleComponent("This is a simple bottom navigation bar that always shows labels")
                Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
                    BottomNavigationAlwaysShowLabelComponent()
                }
                TitleComponent("This is a bottom navigation bar that only shows label for selected item")
                Card(shape = RoundedCornerShape(4.dp), modifier = Modifier.padding(8.dp)) {
                    BottomNavigationOnlySelectedLabelComponent()
                }
            }
        }
    }
}

val listItems = listOf("Home", "Search", "Profile", "Settings")

@Composable
fun BottomNavigationAlwaysShowLabelComponent() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    BottomNavigation(modifier = Modifier.padding(16.dp)) {
        listItems.forEachIndexed { index, label ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                    )
                },
                label = {
                    Text(text = label)
                },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index }
            )
        }
    }
}

@Composable
fun BottomNavigationOnlySelectedLabelComponent() {
    var selected by remember { mutableIntStateOf(0) }
    BottomNavigation(modifier = Modifier.padding(16.dp)) {
        listItems.forEachIndexed { index, label ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                    )
                },
                label = {
                    Text(text = label)
                },
                selected = selected == index,
                onClick = { selected = index },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview()
@Composable
fun BottomNavigationAlwaysShowLabelComponentPreview() {
    BottomNavigationAlwaysShowLabelComponent()
}

@Preview()
@Composable
fun BottomNavigationOnlySelectedLabelComponentPreview() {
    BottomNavigationOnlySelectedLabelComponent()
}