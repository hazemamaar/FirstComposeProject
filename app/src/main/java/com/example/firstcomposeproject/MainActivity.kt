package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressBar(percentage = .8f, number =100 )
            }
        }
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    color: Color = Color.Cyan,
    fontSize: TextUnit = 25.sp,
    strokeWith: Dp = 8.dp,
    radius: Dp = 80.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
) {
    var animPlayed by remember {
        mutableStateOf(false)
    }
    val currentPercentage by animateFloatAsState(
        targetValue = if (animPlayed) percentage else 0f,
        animationSpec = tween(durationMillis = animDuration, delayMillis = animDelay,
            FastOutLinearInEasing)
    )
     LaunchedEffect(key1 = true ){
         animPlayed =true
     }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)) {
        Canvas(modifier = Modifier.size(radius * 2f) ){
            drawArc(color=color , -90f,360*currentPercentage, style = Stroke(strokeWith.toPx(), cap = StrokeCap.Round), useCenter = false)
        }
       Text(text = (currentPercentage * number).toInt().toString(), color=Color.Black, fontSize = fontSize)
    }
}
