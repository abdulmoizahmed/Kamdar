package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.example.moizahmed.test1.R;

/**
 * Created by Moiz Ahmed on 5/10/2016.
 */
public class Splash extends Activity {
    ImageView img;
    Animation fadeIn,fadeOut;
    AnimationSet animation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);

        fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(1500);
        fadeOut.setDuration(1500);

        animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        img = (ImageView) findViewById(R.id.logo1);

        img.startAnimation(animation);



        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 5 seconds
                    sleep(3000);

                    /// / After 5 seconds redirect to another intent
                    Intent i=new Intent(getBaseContext(),MyIntro.class);
                    startActivity(i);
                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };
        background.start();
    }


    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

}