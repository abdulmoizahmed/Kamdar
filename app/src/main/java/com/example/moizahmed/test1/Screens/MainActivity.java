package com.example.moizahmed.test1.Screens;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.moizahmed.test1.R;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;

import belka.us.androidtoggleswitch.widgets.ToggleSwitch;

public class MainActivity extends AppCompatActivity {
    private int lang;
    private Button wel;
//    public Language mlanguage = new Language();
    private int spin_pos;
    private Spinner spin;
    private ToggleSwitch toggleSwitch;
    public DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(getApplicationContext());
        UiInit();
        setLayoutFont();
        BtnListener();
    }


    private void BtnListener() {
        wel.setOnClickListener(myLanguage);
        toggleSwitch.setOnToggleSwitchChangeListener(setLanguage);
    }

    private void UiInit() {
        //Ui Initialization
        wel = (Button) findViewById(R.id.btn_welcome);
        toggleSwitch = (ToggleSwitch) findViewById(R.id.languageSelect);

    }



    ToggleSwitch.OnToggleSwitchChangeListener setLanguage = new ToggleSwitch.OnToggleSwitchChangeListener() {
        @Override
        public void onToggleSwitchChangeListener(int position)
        {
            Language.getInstance().setLanguageId(position);
        }
    };


    Button.OnClickListener myLanguage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent menu = new Intent(MainActivity.this,Main.class);
            startActivity(menu);
            finish();
        }
    };

    public void setLayoutFont() {
 //       Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/nori.ttf");
   //    wel.setTypeface(tf);
    }

}

