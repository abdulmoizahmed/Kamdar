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
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelSurvey;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015 and Umair Younas.
 */
public class roz_servey extends Activity {
    String[] labels;
    int lang;

    private TextView surveyCode;
    private TextView company;
    private TextView expense;
    private TextView ph;
    private TextView date;
    private TextView landNum;

    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private EditText v5;
    Spinner s1;
    String zameen = "";

    SQLiteDatabase db;

    Cursor c;
    private Button submit;
    private Button refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_servey);

        setLanguage();


        initUI();
        setAdapters();

        setLabels();
        startListeners();
    }

    public void setAdapters(){


        GetAdapters adapters = new GetAdapters(getApplicationContext());

        s1.setAdapter(adapters.getLandArray());

    }
    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozsurvey);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozsurvey);
        }

    }


    private void setLabels() {

        surveyCode.setText(labels[0]);
        company.setText(labels[1]);
        landNum.setText(labels[2]);
        expense.setText(labels[3]);
        ph.setText(labels[4]);
        date.setText(labels[5]);



    }

    private void initUI() {

         s1= (Spinner) findViewById(R.id.spin_survey_landno);

        surveyCode= (TextView)findViewById(R.id.surveyCode);
        company= (TextView)findViewById(R.id.surveyCompany);
        landNum= (TextView)findViewById(R.id.textView38);
        expense = (TextView) findViewById(R.id.textView39);
        ph = (TextView) findViewById(R.id.textView40);
        date = (TextView) findViewById(R.id.textView41);

        v1= (EditText) findViewById(R.id.et_surveyCode);
        v2= (EditText) findViewById(R.id.et_surveyCompany);
        v3= (EditText) findViewById(R.id.editText25);
        v4= (EditText) findViewById(R.id.editText26);
        v5= (EditText) findViewById(R.id.editText27);

        submit = (Button) findViewById(R.id.btn_submit);


    }

    private void startListeners() {
        submit.setOnClickListener(new surveyButtonListener());


    }
    private void setSurveyObject() {
        ModelSurvey modelSurvey = new ModelSurvey();

        modelSurvey.setSurveyCode(v1.getText().toString());
        modelSurvey.setCompany(v2.getText().toString());
        modelSurvey.setExpense(v3.getText().toString());
        modelSurvey.setPh(v4.getText().toString());
        modelSurvey.setDate(v5.getText().toString());

        modelSurvey.setLandNumber(s1.getSelectedItem().toString());

        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertSurveyToDb(modelSurvey);
    }


    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_servey.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    public boolean emptyCheck(){
        String id="";
        id = v1.getText().toString();
        String company="";
        company = v2.getText().toString();
        String ph="";
        ph = v4.getText().toString();
        String expense="";
        expense = v3.getText().toString();
        String date="";
        date = v5.getText().toString();

        if (id.equals("")) {
            Toast.makeText(this, "سروے کا نمبر خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (company.equals("")) {
            Toast.makeText(this, "سروے کمپنی خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (expense.equals("")) {
            Toast.makeText(this, "سروے کا خرچہ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (ph.equals("")) {
            Toast.makeText(this, "سروے کی پی ایچ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (date.equals("")) {
            Toast.makeText(this, "سروے تاریخ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }else
            return true;


    }
    public boolean uniqueCheck(){
        db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        String ID="";
        ID = v1.getText().toString();

        String Query = "SELECT * FROM Survey WHERE surveyCode = '"+ ID + "'";


        Cursor c = db.rawQuery(Query,null);

        if(c.getCount() > 0){
            c.close();
            ((EditText) findViewById(R.id.et_surveyCode)).setText("");
            Toast.makeText(getApplicationContext(),  "سروے نمبر پہلے موجود ہے!", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),  "سروے نمبر دوبارا اندراج کریں شکریہ", Toast.LENGTH_SHORT).show();

            return false;
        }else
            return true;
    }



    private class surveyButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    boolean empty = emptyCheck();
                    boolean isUnique = false;

                    if(empty==true)
                        isUnique = uniqueCheck();

                    if(empty == true && isUnique == true) {

                        db.close();
                        setSurveyObject();
                        showDialogMessage();
                    }
                    break;

            }
        }
    }



}
