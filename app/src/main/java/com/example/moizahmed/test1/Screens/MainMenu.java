package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.moizahmed.test1.Model.Language;


/**
 * Created by Moiz Ahmed on 10/19/2015.
 */
public class MainMenu extends AppCompatActivity {
    private String[] labels;
    public int lang;
    private Button in;
    private Button roz;
    private Button info;
    private Button edit;
    private Button delete;
    private Button report;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setLanguage();
        initUI();
        startListener();


    }

    private void startListener() {
        in.setOnClickListener(new MainButtonListener());
        report.setOnClickListener(new MainButtonListener());
        info.setOnClickListener(new MainButtonListener());
        edit.setOnClickListener(new MainButtonListener());
        delete.setOnClickListener(new MainButtonListener());
        roz.setOnClickListener(new MainButtonListener());

    }


    private void initUI() {

        in = (Button) findViewById(R.id.btn_newinput);
        roz = (Button) findViewById(R.id.btn_roznamcha);
        info = (Button) findViewById(R.id.btn_info);
        edit = (Button) findViewById(R.id.btn_edit);
        delete = (Button) findViewById(R.id.btn_delete);
        report = (Button) findViewById(R.id.btn_report);

        //initializing the Language buttons
        in.setText(labels[0]);
        roz.setText(labels[1]);
        report.setText(labels[2]);
        info.setText(labels[3]);
        edit.setText(labels[4]);
        delete.setText(labels[5]);

    }


    public void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_mainMenu);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_mainMenu);
        }
    }


    private class MainButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_newinput:
                    Intent in = new Intent("com.example.moizahmed.test1.NewInput");
                    in.putExtra("language_id", lang);
                    startActivity(in);

                    break;

                case R.id.btn_roznamcha:

                    Intent roz = new Intent(getApplicationContext(), com.example.moizahmed.test1.Screens.Roznamcha.class);
                    roz.putExtra("language_id", lang);
                    startActivity(roz);
                    break;

                case R.id.btn_info:

                    Intent info = new Intent("com.example.moizahmed.test1.Malomat");
                    info.putExtra("language_id", lang);
                    startActivity(info);

                    break;
                case R.id.btn_edit:
                    Intent edit = new Intent("com.example.moizahmed.test1.Edit");
                    edit.putExtra("language_id", lang);
                    startActivity(edit);

                    break;
                case R.id.btn_delete:

                    Intent del = new Intent("com.example.moizahmed.test1.Delete");
                    del.putExtra("language_id", lang);
                    startActivity(del);

                    break;
                case R.id.btn_report:
                    Intent report = new Intent("com.example.moizahmed.test1.Report");
                    report.putExtra("language_id", lang);
                    startActivity(report);
                    break;
            }
        }

    }
}