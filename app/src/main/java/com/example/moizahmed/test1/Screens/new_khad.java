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
public class new_khad extends Activity {
    String[] labels;
    int lang;

    String name;
    String company;// Umair Younas DB Creation And integration.
    String ID;
    String quantity;
    String expense;
    String date;
    //SQLiteDatabase db;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newfertilizer);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();


        TextView number= (TextView)findViewById(R.id.ferNum);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.textView50);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.textView51);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView52);
        place.setText(labels[3]);
        TextView expense1 = (TextView) findViewById(R.id.textView53);
        expense1.setText(labels[4]);
        TextView date1 = (TextView) findViewById(R.id.textView54);
        date1.setText(labels[5]);



       // db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...


        final EditText va= (EditText) findViewById(R.id.ferNumb);
        final EditText v1= (EditText) findViewById(R.id.editText36);
        final EditText v2= (EditText) findViewById(R.id.editText37);
        final EditText v3= (EditText) findViewById(R.id.editText38);
        final EditText v4= (EditText) findViewById(R.id.editText39);
        final EditText v5= (EditText) findViewById(R.id.editText40);
        submit = (Button) findViewById(R.id.btn_submit);




        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("new_khad");
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
                name = v1.getText().toString();
                company = v2.getText().toString();
                quantity = v3.getText().toString();
                expense = v4.getText().toString();
                date = v5.getText().toString();


//                db.execSQL("INSERT INTO Fertilizer VALUES('" + ID.toString() + "','" + name.toString() + "','" + company.toString() + "','" + quantity.toString() + "','" + expense.toString() + "','" + date.toString() + "');");




                AlertDialog alertDialog = new AlertDialog.Builder(new_khad.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });

    }
    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfertilizer);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfertilizer);
        }

    }
}
