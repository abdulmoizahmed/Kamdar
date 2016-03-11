package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_fasl extends Activity {
    String[] labels;
    int lang;
    String cropName;   // Umair Younas DB Creation And integration.
   // String type;
    String season;
    String year;
    SQLiteDatabase db;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_fasal);

        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();

        final EditText v1= (EditText) findViewById(R.id.editText28);
        final EditText v2= (EditText) findViewById(R.id.editText29);
        final EditText v3= (EditText) findViewById(R.id.editText30);
        submit = (Button) findViewById(R.id.btn_submit);


        TextView name= (TextView)findViewById(R.id.txt_faslname);
        name.setText(labels[0]);
        TextView yearr = (TextView) findViewById(R.id.txt_season);
        yearr.setText(labels[1]);
        TextView date = (TextView) findViewById(R.id.txt_date);
        date.setText(labels[2]);





        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("new_fasl");
                menu.putExtra("language_id",lang);
                startActivity(menu);

                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                cropName = v1.getText().toString();
                season = v2.getText().toString();
                year = v3.getText().toString();

//                db.execSQL("INSERT INTO Crop VALUES('" + cropName.toString() + "','" + season.toString() + "','" + year.toString() + "');");




                AlertDialog alertDialog = new AlertDialog.Builder(new_fasl.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });

    }

    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfasal);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfasal);
        }

    }
}
