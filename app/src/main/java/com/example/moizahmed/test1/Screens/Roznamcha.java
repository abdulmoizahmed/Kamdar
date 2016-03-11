package com.example.moizahmed.test1.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import com.example.moizahmed.test1.Model.Language;


/**
 * Created by Moiz Ahmed on 10/19/2015.
 */
public class Roznamcha extends AppCompatActivity{
    //private Spinner spinner1, spinner2;
    private String[] labels;
    public int lang;
    private Button khad;
    private Button tax;
    private Button servey;
    private Button pani;
    private Button machine;
    private Button seed;
    private Button qarz;
    private Intent menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roznamcha);
        setLanguage();
        initUI();
        startListener();

    }

    private void initUI() {
        khad = (Button) findViewById(R.id.btn_fertilizer);
        tax = (Button) findViewById(R.id.btn_tax);
        servey = (Button) findViewById(R.id.btn_servey);
        pani = (Button) findViewById(R.id.btn_water);
        machine = (Button) findViewById(R.id.btn_Machine);
        seed = (Button) findViewById(R.id.btn_seed);
        qarz = (Button) findViewById(R.id.btn_newqarz);
        //initializing the Language buttons

        pani.setText(labels[0]);
        khad.setText(labels[1]);
        seed.setText(labels[2]);
        machine.setText(labels[3]);
        tax.setText(labels[4]);
        servey.setText(labels[5]);
        qarz.setText(labels[6]);
    }


    private void startListener() {
        pani.setOnClickListener(new MainButtonListener());
        khad.setOnClickListener(new MainButtonListener());
        seed.setOnClickListener(new MainButtonListener());
        machine.setOnClickListener(new MainButtonListener());
        tax.setOnClickListener(new MainButtonListener());
        servey.setOnClickListener(new MainButtonListener());
        qarz.setOnClickListener(new MainButtonListener());

    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_roznamcha);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_roznamcha);
        }

    }


    private class MainButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_servey:
                    menu = new Intent("roz_servey");
                    menu.putExtra("language_id",lang);
                    startActivity(menu);
                    break;
                case R.id.btn_tax:
                    menu = new Intent("roz_tax");
                    menu.putExtra("language_id",lang);
                    startActivity(menu);
                    break;
                case R.id.btn_fertilizer:
                    menu = new Intent("roz_khad");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_water:
                    menu = new Intent("roz_pani");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);

                    break;
                case R.id.btn_Machine:
                    menu = new Intent("roz_machine");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_seed:
                    menu = new Intent("roz_seed");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
                case R.id.btn_newqarz:
                    menu = new Intent("new_qarz");
                    menu.putExtra("language_id", lang);
                    startActivity(menu);
                    break;
            }
            }
    }
}
