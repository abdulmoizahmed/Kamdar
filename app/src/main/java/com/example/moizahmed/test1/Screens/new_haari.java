package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_haari extends Activity {

    String[] labels;
    int lang;

                                            // Umair Younas DB Creation And integration.
    String name;
    String CNIC;
    String address;
    String phone;
    String date;
    String conditions;
    String expirience;
    String salary;

    SQLiteDatabase db;
    Button submit;
    Cursor c;
    Cursor d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_haari);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();
/*
        db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        Cursor c = db.rawQuery("SELECT landNumber FROM Land;",null);
        Cursor d = db.rawQuery("SELECT cropName FROM Crop;",null);

        final String[] arraySpinner1 = new String[c.getCount()];
        final String[] arraySpinner2 = new String[d.getCount()];

*/
        final EditText v1= (EditText) findViewById(R.id.hari_name);
        final EditText v2= (EditText) findViewById(R.id.editText13);
        final EditText v3= (EditText) findViewById(R.id.hari_address);
        final EditText v4= (EditText) findViewById(R.id.hari_number);
        final EditText v5= (EditText) findViewById(R.id.hari_income);
        final EditText v6= (EditText) findViewById(R.id.hari_conds);
        final EditText v7= (EditText) findViewById(R.id.hari_);
        final EditText v8= (EditText) findViewById(R.id.hari_experince);

        final Spinner v9= (Spinner) findViewById(R.id.SpinnerLandNumber);
        final Spinner v10= (Spinner) findViewById(R.id.SpinnerfaslNumber);


        v1.setHint(labels[0]);
        TextView number= (TextView)findViewById(R.id.land_number);
        number.setText(labels[1]);
        TextView owner = (TextView) findViewById(R.id.fasal_number);
        owner.setText(labels[2]);
        TextView dimension = (TextView) findViewById(R.id.date);
        dimension.setText(labels[3]);



        v3.setHint(labels[4]);
        v4.setHint(labels[5]);
        v5.setHint(labels[6]);
        v6.setHint(labels[7]);
        v7.setHint(labels[8]);
        v8.setHint(labels[9]);


        /*
        int i=0;
        while(c.moveToNext())
        {
            arraySpinner1[i++] = c.getString(0);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner1);
        v9.setAdapter(adapter);

        int j=0;
        while(d.moveToNext())
        {
            arraySpinner2[j++] = d.getString(0);
        }


        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner2);
        v10.setAdapter(myadapter);

        Spinner mySpinnerLand=(Spinner) findViewById(R.id.SpinnerLandNumber);
        final String landNum = mySpinnerLand.getSelectedItem().toString();

        Spinner mySpinnerFasl=(Spinner) findViewById(R.id.SpinnerfaslNumber);
        final String crop = mySpinnerFasl.getSelectedItem().toString();



        Spinner mySpinner=(Spinner) findViewById(R.id.SpinnerFeedbackType);
        final String contract = mySpinner.getSelectedItem().toString();
*/
        submit = (Button) findViewById(R.id.btn_submit);


        Button refresh,submit;
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("new_haari");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                name = v1.getText().toString();
                date = v2.getText().toString();
                address = v3.getText().toString();
                phone = v4.getText().toString();
                salary = v5.getText().toString();
                conditions = v6.getText().toString();
                CNIC = v7.getText().toString();
                expirience = v8.getText().toString();

              //  db.execSQL("INSERT INTO FarmerContract VALUES('" + name.toString() + "','" + CNIC.toString() + "','" + landNum.toString() + "','" + crop.toString() + "','" + date.toString() + "','" + address.toString() + "','" + phone.toString() + "','" + salary.toString() + "','" + contract.toString() + "','" + expirience.toString() + "');");

*/
                AlertDialog alertDialog = new AlertDialog.Builder(new_haari.this).create();
                alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
                alertDialog.setIcon(R.drawable.logo1);
                alertDialog.show();
            }
        });


    }
    public void setLanguage() {


        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputHari);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputHari);
        }

    }
}
