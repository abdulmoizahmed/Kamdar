package com.example.moizahmed.test1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.example.moizahmed.test1.Model.Language;

import butterknife.ButterKnife;


/**
 * Created by Moiz Ahmed on 10/19/2015.
 */
public class NewInput extends AppCompatActivity {

   private String[] labels;
   public int lang;
    private Button fasal;
    private Button khad;
    private Button land;
    private Button machine;
    private Button haari;
    private Button seed;
    private Button dawai;
    private Intent menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_newinput);
        setLanguage();
        initUI();
        startListener();
    }

    private void startListener() {
        //Listener
        fasal.setOnClickListener(new NewInput.MainButtonListener());
        khad.setOnClickListener(new NewInput.MainButtonListener());
        land.setOnClickListener(new NewInput.MainButtonListener());
        machine.setOnClickListener(new NewInput.MainButtonListener());
        haari.setOnClickListener(new NewInput.MainButtonListener());
        seed.setOnClickListener(new NewInput.MainButtonListener());
        dawai.setOnClickListener(new NewInput.MainButtonListener());

    }

    private void initUI() {
//init Buttons
        fasal =(Button) findViewById(R.id.btn_newfasl);
        khad =(Button) findViewById(R.id.btn_newkhad);
        land=(Button) findViewById(R.id.btn_newzameen);
        machine=(Button) findViewById(R.id.btn_newmachine);
        haari=(Button) findViewById(R.id.btn_newhaari);
        seed=(Button) findViewById(R.id.btn_newseed);
        dawai=(Button) findViewById(R.id.btn_newpesticides);


//init button language
        land.setText(labels[0]);
        machine.setText(labels[1]);
        seed.setText(labels[2]);
        dawai.setText(labels[3]);
        khad.setText(labels[4]);
        haari.setText(labels[5]);
        fasal.setText(labels[6]);


    }

    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_input);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_input);
        }

    }


    private class MainButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_newfasl:
                    menu = new Intent("new_fasl");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newseed:
                    menu = new Intent("new_seed");
                    menu.putExtra("language_id",lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newhaari:
                     menu = new Intent("new_haari");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newkhad:
                    menu = new Intent("new_khad");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newmachine:
                    menu = new Intent("new_machine");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newpesticides:
                    menu = new Intent("new_dawai");
                    menu.putExtra("language_id",lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newzameen:
                    menu = new Intent("new_land");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;



            }
            }
    }
}
