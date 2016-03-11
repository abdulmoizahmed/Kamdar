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

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_seed extends Activity {
    String[] labels;
    int lang;

    String name;          // Umair Younas DB Creation And integration.
    String company;
    String ID;
    String Quantity;
    String Expense;
    String Date;

    //SQLiteDatabase db;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newseed);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();


        TextView number= (TextView)findViewById(R.id.textView15);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.textView61);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.textView46);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView47);
        place.setText(labels[3]);
        TextView expense1 = (TextView) findViewById(R.id.textView48);
        expense1.setText(labels[4]);
        TextView date1 = (TextView) findViewById(R.id.textView49);
        date1.setText(labels[5]);



       // db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        final EditText va= (EditText) findViewById(R.id.seedID);
        final EditText v1= (EditText) findViewById(R.id.editText31);
        final EditText v2= (EditText) findViewById(R.id.editText32);
        final EditText v3= (EditText) findViewById(R.id.editText33);
        final EditText v4= (EditText) findViewById(R.id.editText34);
        final EditText v5= (EditText) findViewById(R.id.editText35);
        submit = (Button) findViewById(R.id.btn_submit);








        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("new_seed");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ID = va.getText().toString();

                name = v1.getText().toString();     //getting values from the form into db...
                company = v2.getText().toString();
                Quantity = v3.getText().toString();
                Expense = v4.getText().toString();
                Date = v4.getText().toString();


         //       db.execSQL("INSERT INTO Seeds VALUES('" + ID.toString() + "','" + name.toString() + "','" + company.toString() + "','" + Quantity.toString() + "','" + Expense.toString() + "','" + Date.toString() + "');");



                AlertDialog alertDialog = new AlertDialog.Builder(new_seed.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });

    }

    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputseed);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputseed);
        }

    }
}
