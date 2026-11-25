package com.example.myapplication

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


var bigShotText = FontFamily(
    Font(R.font.bigshot)
)

//Allows MainActivity.java to display the ButtonMasher screen.
fun displayGreeting(activity: MainActivity){
    activity.setContent {
        GreetScreen()
    }
}

@Composable
fun GreetScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Hello Dr. Das!",
            fontFamily = com.example.myapplication.bigShotText,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
    }

    ElevatedButton(onClick = {
        //Code to execute when clicked
    }){
        Text("Elevated")
    }
}