package com.example.moizahmed.test1.Screens;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.example.moizahmed.test1.Model.DataBaseStarter;
import com.example.moizahmed.test1.Model.Language;

public class MainActivity extends AppCompatActivity {
    private int lang;
    private Button wel;
//    public Language mlanguage = new Language();
    private int spin_pos;
    private Spinner spin;
    public DataBaseStarter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseStarter(getApplicationContext());
        UiInit();
        BtnListener();
    }


    private void BtnListener() {
        wel.setOnClickListener(myLanguage);
    }

    private void UiInit() {
        //Ui Initialization
        wel = (Button) findViewById(R.id.btn_welcome);

    }

    public void setLanguage()
    {
        spin = (Spinner)findViewById(R.id.langselect);
        spin_pos = spin.getSelectedItemPosition();
        Language.getInstance().setLanguageId(spin_pos);

    }





    Button.OnClickListener myLanguage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setLanguage();
            Intent menu = new Intent(getApplicationContext(), com.example.moizahmed.test1.Screens.MainMenu.class);
            menu.putExtra("language_id",lang);
            startActivity(menu);
            finish();
        }
    };


}

