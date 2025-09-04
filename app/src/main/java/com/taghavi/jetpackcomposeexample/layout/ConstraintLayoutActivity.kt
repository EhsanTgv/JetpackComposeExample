package com.taghavi.jetpackcomposeexample.layout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taghavi.jetpackcomposeexample.state.TitleComponent

class ConstraintLayoutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                item {
                    TitleComponent("Simple constraint layout example")
                    SimpleConstraintLayoutComponent()
                }
            }
        }
    }
}

@Composable
fun SimpleConstraintLayoutComponent() {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {

    }
}


@Preview("Simple constraint layout example")
@Composable
fun SimpleConstraintLayoutComponentPreview() {
    Column {
        SimpleConstraintLayoutComponent()
    }
}

//@Preview("Constraint layout example with guidelines")
//@Composable
//fun GuidelineConstraintLayoutComponentPreview() {
//    Column {
//        GuidelineConstraintLayoutComponent()
//    }
//}
//
//@Preview("Constraint layout example with barrier")
//@Composable
//fun BarrierConstraintLayoutComponentPreview() {
//    Column {
//        BarrierConstraintLayoutComponent()
//    }
//}
//
//@Preview("Constraint layout example with bias")
//@Composable
//fun BiasConstraintLayoutComponentPreview() {
//    Column {
//        BiasConstraintLayoutComponent()
//    }
//}