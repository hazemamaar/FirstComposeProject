package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val painter = painterResource(id = R.drawable.amado)
//            val description = "amado is the best naruto"
//            val title = "amado is the best naruto"

            Column(modifier = Modifier.fillMaxSize()) {
                val colorState = remember {
                    mutableStateOf(Color.Yellow)
                }

                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    colorState.value = it
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .background(colorState.value)
                    .fillMaxSize())
            }

//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Black)
//            ) {
//                Text(text = buildAnnotatedString {
//                    withStyle(
//                        style = SpanStyle(
//                                 color = Color.Green
//                        , fontSize = 40.sp
//
//                        )
//                    ){
//                        append("J")
//                    }
//                    append("etpack")
//                    withStyle(
//                        style = SpanStyle(
//                            color = Color.Green
//                            , fontSize = 40.sp
//                        )
//                    ){
//                        append("C")
//                    }
//                    append("ompose")
//                },
//                    color = Color.White,
//                    textAlign = TextAlign.Center,
//                    textDecoration = TextDecoration.Underline,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 30.sp)
//
//            }
        }
    }
}


@Composable
fun ImageCard(
    painter: Painter,
    title: String,
    modifier: Modifier = Modifier,
    contentDescription: String,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(300.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 300f
                        )
                    )
            ) {

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))

            }


        }


    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    Box(modifier = modifier
        .background(color = Color.Green)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        })
}