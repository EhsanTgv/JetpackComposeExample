package com.taghavi.jetpackcomposeexample.theme

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taghavi.jetpackcomposeexample.core.LOREM_IPSUM_1
import kotlinx.coroutines.launch

class DarkModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val enableDarkMode = remember { mutableStateOf(false) }
            CustomTheme(enableDarkMode) {
                ThemedDrawerAppComponent(enableDarkMode)
            }
        }
    }
}

@Composable
fun CustomTheme(enableDarkMode: MutableState<Boolean>, children: @Composable() () -> Unit) {
    val lightColors = lightColors(
        primary = Color(0xFF6200EE),
        primaryVariant = Color(0xFF3700B3),
        onPrimary = Color(0xFFFFFFFF),
        secondary = Color(0xFF03DAC5),
        secondaryVariant = Color(0xFF0000FF),
        onSecondary = Color(0xFF000000),
        background = Color(0xFFFFFFFF),
        onBackground = Color(0xFF000000),
        surface = Color(0xFFFFFFFF),
        onSurface = Color(0xFF000000),
        error = Color(0xFFB00020),
        onError = Color(0xFFFFFFFF)
    )
    val darkColors = darkColors()

    val colors = if (enableDarkMode.value) darkColors else lightColors

    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            textIndent = TextIndent(firstLine = 16.sp),
            textAlign = TextAlign.Justify,
        )
    )

    MaterialTheme(colors = colors, content = children, typography = typography)
}

@Composable
fun ThemedDrawerAppComponent(enableDarkMode: MutableState<Boolean>) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val currentScreen = remember { mutableStateOf(ThemedDrawerAppScreen.Screen1) }
    val scope = rememberCoroutineScope()

    ModalDrawer(
        drawerContent = {
            ThemedDrawerComponent(
                currentScreen = currentScreen,
                closeDrawer = { scope.launch { drawerState.close() } },
            )
        },
        content = {
            ThemedBodyContentComponent(
                currentScreen = currentScreen.value,
                enableDarkMode = enableDarkMode,
                openDrawer = {
                    scope.launch { drawerState.open() }
                }
            )
        }
    )
}

@Composable
fun ThemedDrawerComponent(
    currentScreen: MutableState<ThemedDrawerAppScreen>,
    closeDrawer: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Column(
            modifier = Modifier.clickable(onClick = {
                currentScreen.value = ThemedDrawerAppScreen.Screen1
                closeDrawer()
            }),
            content = {
                Text(text = ThemedDrawerAppScreen.Screen1.name, modifier = Modifier.padding(16.dp))
            }
        )

        Column(
            modifier = Modifier.clickable(onClick = {
                currentScreen.value = ThemedDrawerAppScreen.Screen2
                closeDrawer()
            }),
            content = {
                Text(text = ThemedDrawerAppScreen.Screen2.name, modifier = Modifier.padding(16.dp))
            }
        )

        Column(
            modifier = Modifier.clickable(onClick = {
                currentScreen.value = ThemedDrawerAppScreen.Screen3
                closeDrawer()
            }),
            content = {
                Text(text = ThemedDrawerAppScreen.Screen3.name, modifier = Modifier.padding(16.dp))
            }
        )
    }
}

@Composable
fun ThemedBodyContentComponent(
    currentScreen: ThemedDrawerAppScreen,
    enableDarkMode: MutableState<Boolean>,
    openDrawer: () -> Unit,
) {
    val onCheckChanged = { _: Boolean ->
        enableDarkMode.value = !enableDarkMode.value
    }

    when (currentScreen) {
        ThemedDrawerAppScreen.Screen1 -> ThemedScreen1Component(
            enableDarkMode.value,
            openDrawer,
            onCheckChanged,
        )
        ThemedDrawerAppScreen.Screen2 -> ThemedScreen2Component(
            enableDarkMode.value,
            openDrawer,
            onCheckChanged,
        )
        ThemedDrawerAppScreen.Screen3 -> ThemedScreen3Component(
            enableDarkMode.value,
            openDrawer,
            onCheckChanged,
        )
    }
}

@Composable
fun ThemedScreen1Component(
    enableDarkMode: Boolean,
    openDrawer: () -> Unit,
    onCheckChanged: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Screen 1") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Switch(checked = enableDarkMode, onCheckedChange = onCheckChanged)
                Text(
                    text = "Enable Dark Mode",
                    style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Surface(modifier = Modifier.weight(1f), color = MaterialTheme.colors.surface) {
            Text(
                text = LOREM_IPSUM_1,
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ThemedScreen2Component(
    enableDarkMode: Boolean,
    openDrawer: () -> Unit,
    onCheckChanged: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Screen 2") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Switch(checked = enableDarkMode, onCheckedChange = onCheckChanged)
                Text(
                    text = "Enable Dark Mode",
                    style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Surface(modifier = Modifier.weight(1f), color = MaterialTheme.colors.surface) {
            Text(
                text = LOREM_IPSUM_1,
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ThemedScreen3Component(
    enableDarkMode: Boolean,
    openDrawer: () -> Unit,
    onCheckChanged: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Screen 3") },
            navigationIcon = {
                IconButton(onClick = openDrawer) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            }
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Switch(checked = enableDarkMode, onCheckedChange = onCheckChanged)
                Text(
                    text = "Enable Dark Mode",
                    style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        Surface(modifier = Modifier.weight(1f), color = MaterialTheme.colors.surface) {
            Text(
                text = LOREM_IPSUM_1,
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

enum class ThemedDrawerAppScreen {
    Screen1,
    Screen2,
    Screen3,
}

@Preview
@Composable
fun CustomThemeLightPreview() {
    CustomTheme(enableDarkMode = remember { mutableStateOf(false) }) {
        Card {
            Text("Preview Text", modifier = Modifier.padding(32.dp))
        }
    }
}

@Preview
@Composable
fun CustomThemeDarkPreview() {
    CustomTheme(enableDarkMode = remember { mutableStateOf(true) }) {
        Card {
            Text("Preview Text", modifier = Modifier.padding(32.dp))
        }
    }
}