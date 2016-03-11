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
import android.widget.TextView;

import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_machine extends Activity {


    String[] labels;
    int lang;

    // Umair Younas DB Creation And integration.
    String model;
    String name;
    String company;
    String expense;
    String date;

    SQLiteDatabase db;
    Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newmachine);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();

        TextView number= (TextView)findViewById(R.id.textView18);
        number.setText(labels[0]);
        TextView owner = (TextView) findViewById(R.id.textView17);
        owner.setText(labels[1]);
        TextView dimension = (TextView) findViewById(R.id.textView20);
        dimension.setText(labels[2]);
        TextView place = (TextView) findViewById(R.id.textView59);
        place.setText(labels[3]);
        TextView expense1 = (TextView) findViewById(R.id.textView21);
        expense1.setText(labels[4]);
        TextView date1 = (TextView) findViewById(R.id.textView22);
        date1.setText(labels[5]);




       // db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        final EditText v1= (EditText) findViewById(R.id.modelNo);
        final EditText v2= (EditText) findViewById(R.id.editText15);
        final EditText v3= (EditText) findViewById(R.id.editText16);
        final EditText v4= (EditText) findViewById(R.id.editText17);
        final EditText v5= (EditText) findViewById(R.id.editText18);



        Spinner TypeSpinner=(Spinner) findViewById(R.id.spinnerType);
        final String ownership = TypeSpinner.getSelectedItem().toString();

        submit = (Button) findViewById(R.id.btn_submit);

        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("new_machine");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                model = v1.getText().toString();
                name= v2.getText().toString();
                company= v3.getText().toString();
                expense= v4.getText().toString();
                date= v5.getText().toString();


             //   db.execSQL("INSERT INTO NewMachine VALUES('" + model.toString() + "','" + name.toString() + "','" + company.toString() + "','" + ownership.toString() + "','" + expense.toString() + "','" + date.toString() + "');");



                AlertDialog alertDialog = new AlertDialog.Builder(new_machine.this).create();
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
