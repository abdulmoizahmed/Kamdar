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

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.DataBaseHelper;
//import com.example.moizahmed.test1.Model.DataBaseStarter;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelIssueWater;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_pani extends Activity {
    String[] labels;
    int lang;

    private TextView landNumber;
    private TextView duration;
    private TextView date;
    String landNumb = "";

    private EditText v1;
    private EditText v2;
    Spinner v3;


    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_pani);
        setLanguage();

        initUI();
        setAdapters();

        setLabels();
        startListeners();
    }
    public void setAdapters(){



        GetAdapters adapters = new GetAdapters(getApplicationContext());
        v3.setAdapter(adapters.getLandArray());


    }
    private void setLabels() {
        landNumber.setText(labels[0]);
        duration.setText(labels[2]);
        date.setText(labels[3]);



    }

    private void initUI() {

         v3= (Spinner) findViewById(R.id.spinner_pani_landNo);
        landNumber= (TextView)findViewById(R.id.text_llandno);
        duration= (TextView)findViewById(R.id.textView);
        date = (TextView) findViewById(R.id.textView2);
        v1= (EditText) findViewById(R.id.et_pani_duration);
        v2= (EditText) findViewById(R.id.et_pani_date);

        submit = (Button) findViewById(R.id.btn_submit);

    }

    private void startListeners() {
        submit.setOnClickListener(new PaniButtonListener());

    }
    private void setPaniObject() {
        ModelIssueWater modelIssueWater = new ModelIssueWater();

        modelIssueWater.setLandNumber(v3.getSelectedItem().toString());
        modelIssueWater.setDuration(v1.getText().toString());
        modelIssueWater.setDate(v2.getText().toString());


        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertIssueWaterToDb(modelIssueWater);
    }


    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_pani.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }
    public boolean emptyCheck(){

        String duration="";
        duration = v1.getText().toString();
        String date="";
        date = v2.getText().toString();

        if (duration.equals("")) {
            Toast.makeText(this, "پانی کا دورانیہ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (date.equals("")) {
            Toast.makeText(this, "پانی تاریخ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }else
            return true;


    }


    private class PaniButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    boolean empty = emptyCheck();
                    if(empty == true ) {
                        setPaniObject();
                        showDialogMessage();
                    }
                    break;

            }
        }
    }

    public void setLanguage() {


        if( Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozpani);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozpani);
        }

    }
}
