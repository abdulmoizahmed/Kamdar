package com.example.moizahmed.test1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by Moiz Ahmed on 4/23/2016.
 */
public class MyIntro extends AppIntro
{
    @Override
    public void init(@Nullable Bundle savedInstanceState) {


        String title1 = getResources().getString(R.string.appIntroKami);
        String description1 = getResources().getString(R.string.appIntroKamiDetail);
        String title2 = getResources().getString(R.string.appIntroTitle1);
        String description2 = getResources().getString(R.string.appIntroTitle1Detail);
        String title3 = getResources().getString(R.string.appIntroReport);
        String description3 = getResources().getString(R.string.appIntroReportDetails);

        int image = R.drawable.farm_small;
        int image2 = R.drawable.appi_small;
        int image3 = R.drawable.report;
        int color = getResources().getColor(R.color.intro_bg_color_1);
        int color2 =getResources().getColor(R.color.intro_bg_color_2);
        int color3 =getResources().getColor(R.color.intro_bg_color_3);

        addSlide(AppIntroFragment.newInstance(title1, description1,image,color));
        addSlide(AppIntroFragment.newInstance(title2, description2,image2,color2));
        addSlide(AppIntroFragment.newInstance(title3, description3,image3,color3));

    }

    @Override
    public void onSkipPressed() {
        Intent my  = new Intent(MyIntro.this,MainActivity.class);
        startActivity(my);
        finish();

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        Intent my  = new Intent(MyIntro.this,MainActivity.class);
        startActivity(my);
        finish();

    }

    @Override
    public void onSlideChanged() {

    }
}
