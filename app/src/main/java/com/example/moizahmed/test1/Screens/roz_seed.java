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
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelIssueSeed;

/**
 * Created by Moiz Ahmed on 11/16/2015 and Umair Younas.
 */
public class roz_seed extends Activity {

    String[] labels;
    int lang;

    private TextView ID;
    private TextView landNumber;
    private TextView Expense;
    private TextView company;
    private TextView Quantity;
    private TextView Date;

    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;

    String seedno = "";
    String landNo = "";

    Cursor c;
    Cursor d;

    SQLiteDatabase db;

    private Button submit;
    private Button refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_seed);

        setLanguage();

        spinValues();

        initUI();
        setLabels();
        startListeners();


    }

    public void spinValues(){


        db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        Cursor c = db.rawQuery("SELECT landNumber FROM Land;",null);
        Cursor d = db.rawQuery("SELECT ID FROM Seeds;",null);

        final String[] arraySpinner1 = new String[c.getCount()];
        final String[] arraySpinner2 = new String[d.getCount()];

        final Spinner v1= (Spinner) findViewById(R.id.spin_rozSeed_ID);
        final Spinner v2= (Spinner) findViewById(R.id.spin_rozSeed_landNum);
        int i=0;
        while(c.moveToNext())
        {
            arraySpinner1[i++] = c.getString(0);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner1);
        v2.setAdapter(adapter);

        int j=0;
        while(d.moveToNext())
        {
            arraySpinner2[j++] = d.getString(0);
        }


        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner2);
        v1.setAdapter(myadapter);

        Spinner mySpinnerLand=(Spinner) findViewById(R.id.spin_rozSeed_landNum);
        final String landNum = mySpinnerLand.getSelectedItem().toString();

        Spinner mySpinnerID=(Spinner) findViewById(R.id.spin_rozSeed_ID);
        final String id = mySpinnerID.getSelectedItem().toString();


        landNo = landNum;
        seedno = id;

        db.close();

    }

    private void setLabels() {
        ID.setText(labels[0]);
        landNumber.setText(labels[1]);
        Expense.setText(labels[2]);
        Quantity.setText(labels[3]);
        Date.setText(labels[4]);


    }

    private void initUI() {
        ID= (TextView)findViewById(R.id.textView1);
        landNumber = (TextView) findViewById(R.id.textView8);
        Expense = (TextView) findViewById(R.id.textView9);
        Quantity = (TextView) findViewById(R.id.textView10);
        Date = (TextView) findViewById(R.id.textView11);

        v1= (EditText) findViewById(R.id.editText5);
        v3= (EditText) findViewById(R.id.editText6);
        v4= (EditText) findViewById(R.id.editText7);

        submit = (Button) findViewById(R.id.btn_submit);
        refresh =(Button) findViewById(R.id.refresh);

    }

    private void startListeners() {
        submit.setOnClickListener(new IssueSeedButtonListener());
        refresh.setOnClickListener(new IssueSeedButtonListener());

    }
    private void setSeedObject() {
        ModelIssueSeed modelIssueSeed = new ModelIssueSeed();

        modelIssueSeed.setID(seedno);
        modelIssueSeed.setLandNumber(landNo);
        modelIssueSeed.setExpense(v1.getText().toString());
        modelIssueSeed.setQuantity(v3.getText().toString());
        modelIssueSeed.setDate(v4.getText().toString());
        modelIssueSeed.setCompany("");

        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertIssueSeedToDb(modelIssueSeed);
    }


    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_seed.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    public boolean emptyCheck(){

        String quantity="";
        quantity = v3.getText().toString();
        String expense="";
        expense = v1.getText().toString();
        String date="";
        date = v4.getText().toString();

        if (expense.equals("")) {
            Toast.makeText(this, "بیج کا خرچہ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        } if (quantity.equals("")) {
            Toast.makeText(this, "بیج کی بوریاں خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (date.equals("")) {
            Toast.makeText(this, "بیج تاریخ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }else
            return true;


    }

    private class IssueSeedButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    boolean empty = emptyCheck();
                    if(empty == true ) {
                        setSeedObject();
                        showDialogMessage();
                    }
                    break;
                case R.id.refresh:
                    Intent rozSeed = new Intent(getApplicationContext(), com.example.moizahmed.test1.Screens.roz_seed.class);
                    startActivity(rozSeed);
                    finish();
                    break;

            }
        }
    }



    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozseed);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozseed);
        }

    }
}
