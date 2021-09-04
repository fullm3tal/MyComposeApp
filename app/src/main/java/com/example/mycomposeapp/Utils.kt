package com.example.mycomposeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.mycomposeapp.ui.theme.MyComposeAppTheme

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeAppTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ConstraintThreeBox(){

    val constraintSet = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val blueBox = createRefFor("blueBox")

        constrain(blueBox){
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(greenBox){
            start.linkTo(blueBox.end)
            top.linkTo(blueBox.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox){
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.top)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

    }

    ConstraintLayout(constraintSet, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(color = Color.Blue)
            .layoutId("blueBox"))

        Box(modifier = Modifier.background(color = Color.Green)
            .layoutId("greenBox"))

        Box(modifier = Modifier.background(color = Color.Red)
            .layoutId("redBox"))
    }



}






