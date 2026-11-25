package com.example.myapplication

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize


fun displaySplash(activity: MainActivity){ //Allows the main to call this composable function
    activity.setContent {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            AnimatedExplodeSplash(
                onAnimationFinished = {
                    activity.onSplashFinished()
                }
            )
        }
    }
}


@Composable
//@Composable tells Jetpack Compose that the function is responsible for describing part of the app's UI
//Unlike a regular Kotlin function, a composable can display UI elements

//The inside part notifies another part of the app when the explosion animation finishes.
fun AnimatedExplodeSplash(onAnimationFinished: () -> Unit){

    //Creates a variable called currentFrame that can change.
    //Use var instead of val because the frame number needs to increase throughout the animation.
    var currentSplosionFrame by remember {mutableIntStateOf(0)}

    //Tracks the current frame of Queen's laughing animation
    var currentQueenFrame by remember {mutableIntStateOf(0) }

    val explFrames = listOf(
        R.drawable.explode000_no_bg,
        R.drawable.explode001_no_bg,
        R.drawable.explode002_no_bg,
        R.drawable.explode003_no_bg,
        R.drawable.explode004_no_bg,
        R.drawable.explode005_no_bg,
        R.drawable.explode007_no_bg,
        R.drawable.explode008_no_bg,
        R.drawable.explode009_no_bg,
        R.drawable.explode010_no_bg,
        R.drawable.explode011_no_bg,
        R.drawable.explode012_no_bg,
        R.drawable.explode014_no_bg,
        R.drawable.explode015_no_bg,
        R.drawable.explode016_no_bg,
        R.drawable.explode017_no_bg,
        R.drawable.explode020_no_bg
    )

    val queenSplashFrames = listOf(
        R.drawable.queenchair1,
        R.drawable.queenchair2
    )

    //Gets access to the Android environment the app is running in
    val context = LocalContext.current

    //mediaPlayer var will hold an Android MediaPlayer object, which can control audio playback.
    //mediaPlayer?.start()  = Play the sound
    //mediaPlayer?.pause()  = Pause the sound
    //mediaPlayer?.release() = Free the resources
    //Question mark is the Kotlin safe call operator
    val splosionPlayer = remember(context){
        MediaPlayer.create(context, R.raw.splosion)
    }

    val laughPlayer = remember(context){
        MediaPlayer.create(context, R.raw.snd_queen_laugh_0)
    }

    // Releases the MediaPlayer when this composable disappears
    DisposableEffect(splosionPlayer, laughPlayer){
        onDispose{
            splosionPlayer?.release()
            laughPlayer?.release()
        }
    }


    //LaunchedEffect Starts a coroutine when the composable enters the UI
    //Coroutines allow Kotlin to perform tasks over time without freezing the app's interface
    //LaunchedEffect Starts a coroutine when the composable enters the UI

    LaunchedEffect(splosionPlayer, laughPlayer){

        splosionPlayer?.let { player ->
            player.playbackParams = player.playbackParams.setSpeed(1.5f) //1.5 Speed
            player.start()
        }

        for (i in explFrames.indices){ //This loops through every valid index in the frames list.
            currentSplosionFrame = i

            if(i == 1){
                laughPlayer?.start()
            }
            delay(50.milliseconds)
        }

        //Plays Queen's laughing sound effect after the explosion

        //Animates Queen laughing after the explosion (sprite swap cycle 4 times)
        repeat(3) {
            for (i in queenSplashFrames.indices) {
                currentQueenFrame = i
                delay(200.milliseconds)
            }
        }

        //Notify app when animation has finished
        onAnimationFinished()
    }

    Box(contentAlignment = Alignment.Center) {

        //Queen laughing - bottom layer
        Image(
            painter = painterResource(
                queenSplashFrames[currentQueenFrame]
            ),
            contentDescription = "Queen Laughing",
        )


        //Image() is a built-in Jetpack Compose composable. Its job is to display an image on the app's screen
        //painterResource() function loads an image from the Android project's drawable resources and provides
        //a Painter that Compose can use to draw it.
        Image(
            painter = painterResource(
                explFrames[currentSplosionFrame]
            ),
            //For accessibility use
            contentDescription = "Explosion Animation",
            //A Modifier lets you customize how a composable looks, is sized, or is positioned.
            //Here I am scaling the size of the sprite
            modifier = Modifier.size(240.dp) //240 density-independent pixels.
        )

    }
}