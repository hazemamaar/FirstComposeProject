package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val greenBoxId ="greenBox"
            val blackBoxId ="blackBox"
           val constrains= ConstraintSet(){
                val greenBox = createRefFor(greenBoxId)
               val blackBox = createRefFor(blackBoxId)
               val guideLine=createGuidelineFromTop(.5f)
               constrain(greenBox){
                   top.linkTo(guideLine)
                   start.linkTo(parent.start)
                   width = Dimension.value(150.dp)
                   height = Dimension.value(150.dp)
               }
               constrain(blackBox){
                   top.linkTo(parent.top)
                   start.linkTo(greenBox.end)
                   width = Dimension.value(150.dp)
                   height = Dimension.value(150.dp)
               }
               createHorizontalChain(greenBox,blackBox, chainStyle = ChainStyle.Spread)
            }
            ConstraintLayout(constrains, modifier = Modifier.fillMaxSize()) {
                BoxWithConstraints(modifier= Modifier
                    .background(Color.Green)
                    .layoutId(greenBoxId)) {

                }
                Box(modifier= Modifier
                    .background(Color.Black)
                    .layoutId(blackBoxId))
            }

        }
    }
}


