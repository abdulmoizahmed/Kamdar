package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.moizahmed.test1.Model.Language;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_seed extends Activity {

    String[] labels;
    int lang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_seed);
        setLanguage();

        TextView number= (TextView)findViewById(R.id.textView1);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.textView8);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.textView99);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView9);
        place.setText(labels[3]);
        TextView expense1 = (TextView) findViewById(R.id.textView10);
        expense1.setText(labels[4]);
        TextView expense = (TextView) findViewById(R.id.textView11);
        expense.setText(labels[5]);


        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("roz_seed");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(roz_seed.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });
    }
    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozseed);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozseed);
        }

    }
}
