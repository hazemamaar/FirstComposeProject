package com.example.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            LazyColumn{
                itemsIndexed(listOf(
                    "hazem","ammar","sayed"
                )){
                    index, item ->
                    Text(text = "$item $index", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 25.sp, modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp))
                }
//                items(500){
//                    Text(text = "Item $it", fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, fontSize = 25.sp, modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(12.dp))
//                }
            }
        }
    }
}


