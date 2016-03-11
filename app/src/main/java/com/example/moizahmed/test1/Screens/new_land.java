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
public class new_land extends Activity {
    String[] labels;
    int lang;

    String landNumber;
    String landOwner;// Umair Younas DB Creation And integration.
    String dimensions;
    String landLoc;
   // SQLiteDatabase db;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newland);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();


        final EditText v1= (EditText) findViewById(R.id.landNumb);
        final EditText v2= (EditText) findViewById(R.id.ownerName);
        final EditText v3= (EditText) findViewById(R.id.dims);
        final EditText v4= (EditText) findViewById(R.id.editText12);
        submit = (Button) findViewById(R.id.btn_submit);

     //   db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        TextView number= (TextView)findViewById(R.id.textView12);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.textView13);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.textView14);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView16);
        place.setText(labels[3]);



        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("new_land");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                landNumber = v1.getText().toString();
                landOwner = v2.getText().toString();
                dimensions = v3.getText().toString();
                landLoc = v4.getText().toString();


          //      db.execSQL("INSERT INTO Land VALUES('" + landNumber.toString() + "','" + landOwner.toString() + "','" + dimensions.toString() + "','" + landLoc.toString() + "');");




                AlertDialog alertDialog = new AlertDialog.Builder(new_land.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });

    }
    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_newland);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_newland);
        }

    }
}
