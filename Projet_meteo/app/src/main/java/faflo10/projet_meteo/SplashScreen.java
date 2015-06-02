package faflo10.projet_meteo;

import faflo10.projet_meteo.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class SplashScreen extends Activity {

    private static int SET_TIMEOUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent change = new Intent(SplashScreen.this,StartMenu.class);
                startActivity(change);
            }
        },SET_TIMEOUT);
    }


}
