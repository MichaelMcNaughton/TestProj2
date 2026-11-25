package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends ComponentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        showSplash();
    }

    public void showSplash(){ //Display the SplashScreen Activity
        AnimatedSplashKt.displaySplash(this);
    }

    public void onSplashFinished(){
        GreetScreenKt.displayGreeting(this);
    }

    public void showButtonMasher(){ //Display the ButtonMasher Activity
        ButtonMasherKt.displayButtonMasher(this);
    }
}