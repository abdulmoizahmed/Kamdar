package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_tax extends Activity {

    String[] labels;
    int lang;

    // Umair Younas DB Creation And integration.
    String ID;
    String company;
    String expense;

    SQLiteDatabase db;
    Button submit;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_taxashar);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();

        TextView number= (TextView)findViewById(R.id.textView23);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.textView24);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.txt_tax_amount);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView25);
        place.setText(labels[3]);
        TextView place1 = (TextView) findViewById(R.id.textView26);
        place1.setText(labels[4]);


        db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        Cursor c = db.rawQuery("SELECT landNumber FROM Land;",null);

        final String[] arraySpinner = new String[c.getCount()];

       // final Spinner v1= (Spinner) findViewById(R.id.spinner5);

        Spinner mySpinnerType=(Spinner) findViewById(R.id.spinner5);
        final String type = mySpinnerType.getSelectedItem().toString();

        final EditText v2= (EditText) findViewById(R.id.editText19);
        final EditText v3= (EditText) findViewById(R.id.taxComp);

        final Spinner v4= (Spinner) findViewById(R.id.spinner6);

        int i=0;
        while(c.moveToNext())
        {
            arraySpinner[i++] = c.getString(0);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        v4.setAdapter(adapter);

        final EditText v5= (EditText) findViewById(R.id.editText20);
        submit = (Button) findViewById(R.id.btn_submit);

        Spinner mySpinner=(Spinner) findViewById(R.id.spinner6);
        final String landNum = mySpinner.getSelectedItem().toString();


        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("roz_tax");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //type = v1.getText().toString();

                ID = v2.getText().toString();
                company= v3.getText().toString();

                //landNum = v4.getText().toString();

                expense = v5.getText().toString();


             //  db.execSQL("INSERT INTO Tax VALUES('" + type.toString() + "','" + ID.toString() + "','" + company.toString() + "','" + landNum.toString() + "','" + expense.toString() + "');");



                AlertDialog alertDialog = new AlertDialog.Builder(roz_tax.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });
    }
    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_roztax);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_roztax);
        }

    }
}
