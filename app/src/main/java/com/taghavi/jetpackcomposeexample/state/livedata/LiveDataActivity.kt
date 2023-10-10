package com.taghavi.jetpackcomposeexample.state.livedata

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import com.taghavi.jetpackcomposeexample.core.Person
import com.taghavi.jetpackcomposeexample.core.getSuperheroList

class LiveDataActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[SuperheroesViewModel::class.java]
        setContent {
            LiveDataComponent(viewModel.superheroes)
        }
    }
}

@Composable
fun LiveDataComponent(personListLiveData: LiveData<List<Person>>) {
    val personList by personListLiveData.observeAsState(initial = emptyList())

    if (personList.isEmpty()) {
        LiveDataLoadingComponent()
    } else {
        LiveDataComponentList(personList)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LiveDataComponentList(personList: List<Person>) {
    LazyColumn {
        items(
            items = personList, itemContent = { person ->
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillParentMaxWidth()
                        .padding(8.dp)
                ) {
                    ListItem(
                        text = {
                            Text(
                                text = person.name,
                                style = TextStyle(
                                    fontFamily = FontFamily.Serif,
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        },
                        secondaryText = {
                            Text(
                                text = "Age: ${person.age}", style = TextStyle(
                                    fontFamily = FontFamily.Serif,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    color = Color.DarkGray,
                                )
                            )
                        },
                        icon = {
                            person.profilePictureUrl?.let { imageUrl ->
                                NetworkImageComponentPicasso(
                                    url = imageUrl,
                                    modifier = Modifier
                                        .width(60.dp)
                                        .height(60.dp)
                                )
                            }
                        }
                    )
                }
            }
        )
    }
}

@Composable
fun LiveDataLoadingComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
    ) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(CenterHorizontally))
    }
}

@Composable
fun LaunchInCompositionComponent(viewModel: SuperheroesViewModel) {
    val personList = remember { mutableStateListOf<Person>() }

    LaunchedEffect(Unit) {
        val list = viewModel.loadSuperheroes()
        personList.addAll(list)
    }

    if (personList.isEmpty()) {
        LiveDataLoadingComponent()
        return
    }

    LiveDataComponentList(personList)
}

@Preview
@Composable
fun LiveDataComponentListPreview() {
    LiveDataComponentList(getSuperheroList())
}

@Preview
@Composable
fun LiveDataLoadingComponentPreview() {
    LiveDataLoadingComponent()
}

@Composable
fun NetworkImageComponentPicasso(
    url: String,
    modifier: Modifier = Modifier
) {
    // Source code inspired from - https://kotlinlang.slack.com/archives/CJLTWPH7S/p1573002081371500.
    // Made some minor changes to the code Leland posted.
    val sizeModifier = modifier
        .fillMaxWidth()
        .sizeIn(maxHeight = 200.dp)
    var image by remember { mutableStateOf<ImageBitmap?>(null) }
    var drawable by remember { mutableStateOf<Drawable?>(null) }
    // Sometimes we need to make changes to the state of the app. For those cases, Composes provides
    // some Effect API's which provide a way to perform side effects in a predictable manner.
    // DisposableEffect is one such side effect API that provides a mechanism to perform some
    // clean up actions if the key to the effect changes or if the composable leaves composition.
    DisposableEffect(url) {
        val picasso = Picasso.get()
        val target = object : Target {
            override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                drawable = placeHolderDrawable
            }

            override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                drawable = errorDrawable
            }

            override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                image = bitmap?.asImageBitmap()
            }
        }
        picasso
            .load(url)
            .into(target)
        onDispose {
            image = null
            drawable = null
            picasso.cancelRequest(target)
        }
    }

    val theImage = image
    val theDrawable = drawable
    if (theImage != null) {
        // Column is a composable that places its children in a vertical sequence. You
        // can think of it similar to a LinearLayout with the vertical orientation.
        // In addition we also pass a few modifiers to it.

        // You can think of Modifiers as implementations of the decorators pattern that are
        // used to modify the composable that its applied to.
        Column(
            modifier = sizeModifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            // Image is a pre-defined composable that lays out and draws a given [ImageBitmap].
            Image(bitmap = theImage, contentDescription = null)
        }
    } else if (theDrawable != null) {
        // We use the Canvas composable that gives you access to a canvas that you can draw
        // into. We also pass it a modifier.
        Canvas(modifier = sizeModifier) {
            drawIntoCanvas { canvas ->
                theDrawable.draw(canvas.nativeCanvas)
            }
        }
    }
}