package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_pani extends Activity {
    String[] labels;
    int lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_pani);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();

        TextView number= (TextView)findViewById(R.id.text_llandno);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.text_faslname);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.textView);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView2);
        place.setText(labels[3]);


        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("roz_pani");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(roz_pani.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });
    }

    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozpani);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozpani);
        }

    }
}
