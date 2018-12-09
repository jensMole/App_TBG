package com.belgiumgames.tbg.app_tbg;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Aanmaken van splashscreen met opties.
        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundColor(Color.parseColor("#3e3e3e"))
                .withLogo(R.mipmap.tbg_rond);

        // Creeren van splashscreen wat net is aangemaakt.
        View easySplashScreen = config.create();
        // Zetten van de content naar de splashscreen.
        setContentView(easySplashScreen);

    }
}
