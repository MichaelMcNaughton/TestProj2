package com.example.myapplication

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//Allows MainActivity.java to display the ButtonMasher screen.
fun displayButtonMasher(activity: MainActivity){
    activity.setContent {
        ButtonMasher()
    }
}

@Composable
fun ButtonMasher(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Button Masher")
    }
}