package com.example.myapplication

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.RectangleShape


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
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Text(
            text = "Hello Dr. Das!",
            fontFamily = bigShotText,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )

        ElevatedButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 120.dp),
            shape = RoundedCornerShape(8.dp)
        ){
            Text(
                text = "Egg",
                fontFamily = bigShotText,
                fontSize = 20.sp
            )
        }

        ElevatedButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 10.dp),
            shape = RoundedCornerShape(8.dp)
        ){
            Text(
                text = "Sandbox",
                fontFamily = bigShotText,
                fontSize = 20.sp
            )
        }

    }
}