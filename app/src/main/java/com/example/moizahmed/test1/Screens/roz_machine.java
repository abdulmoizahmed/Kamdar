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
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelIssueMachine;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015 and Umair Younas.
 */
public class roz_machine extends Activity {
    String[] labels;
    int lang;
    private EditText v1;
    private EditText v2;
    private EditText v3;

    private TextView modelNumber;
    private TextView landNumber;
    private TextView cropName;
    private TextView duration;
    private TextView Expense;
    private TextView date;

    String id = "";
    String landno = "";
    String fasal = "";

    SQLiteDatabase db;
    Button submit;
    Button refresh;
    Spinner s1,s2,s3;

    Cursor c;
    Cursor d;
    Cursor e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_machine);

        setLanguage();



        initUI();

        setAdapters();
        setLabels();
        startListeners();

    }



    public void setAdapters(){

        GetAdapters adapters = new GetAdapters(getApplicationContext());

        s1.setAdapter(adapters.getMachineNo());
        s2.setAdapter(adapters.getLandArray());
        s3.setAdapter(adapters.getFasalArraySpinner());


    }


    private void setLabels() {
        modelNumber.setText(labels[0]);
        landNumber.setText(labels[1]);
        cropName.setText(labels[2]);
        duration.setText(labels[3]);
        Expense.setText(labels[4]);
        date.setText(labels[5]);


    }

    private void initUI() {
        modelNumber= (TextView)findViewById(R.id.textView32);
        landNumber = (TextView) findViewById(R.id.textView33);
        cropName = (TextView) findViewById(R.id.textView34);
        duration = (TextView) findViewById(R.id.textView35);
        Expense = (TextView) findViewById(R.id.textView36);
        date = (TextView) findViewById(R.id.textView37);

         s1= (Spinner) findViewById(R.id.spin_rozMachine_no);
         s2= (Spinner) findViewById(R.id.spin_rozMachine_land);
         s3= (Spinner) findViewById(R.id.spin_rozMachine_crop);


        v1= (EditText) findViewById(R.id.editText23);
        v2= (EditText) findViewById(R.id.editText24);
        v3= (EditText) findViewById(R.id.et_rozMachine_duration);

        submit = (Button) findViewById(R.id.btn_submit);


    }

    private void startListeners() {
        submit.setOnClickListener(new IssueMachineButtonListener());


    }
    private void setMachineObject() {
        ModelIssueMachine modelIssueMachine = new ModelIssueMachine();

        modelIssueMachine.setLandNumber(s1.getSelectedItem().toString());
        modelIssueMachine.setModelNumber(s2.getSelectedItem().toString());
        modelIssueMachine.setCropName( s3.getSelectedItem().toString());
        modelIssueMachine.setDate(v1.getText().toString());
        modelIssueMachine.setExpense(v2.getText().toString());
        modelIssueMachine.setDuration(v3.getText().toString());




        DataBaseHelper dbO = new DataBaseHelper(getApplicationContext());
        dbO.insertIssueMachineToDb(modelIssueMachine);
    }


    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_machine.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    public boolean emptyCheck(){

        String duration="";
        duration = v3.getText().toString();
        String expense="";
        expense = v1.getText().toString();
        String date="";
        date = v2.getText().toString();

        if (duration.equals("")) {
            Toast.makeText(this, "مشین دورانیہ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (expense.equals("")) {
            Toast.makeText(this, "مشین خرچہ خالی ہے ", Toast.LENGTH_SHORT).show();
            return false;
        }if (date.equals("")) {
            Toast.makeText(this, "مشین تاریخ خالی ہے ", Toast.LENGTH_SHORT).show();
            return false;
        }else
            return true;


    }

    private class IssueMachineButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    boolean empty = emptyCheck();
                    if(empty == true ) {
                        setMachineObject();
                        showDialogMessage();
                    }
                    break;


            }
        }
    }


    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozmachine);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozmachine);
        }

    }
}
