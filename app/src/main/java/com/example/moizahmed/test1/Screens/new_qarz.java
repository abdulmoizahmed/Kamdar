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
import com.example.moizahmed.test1.Model.ModelLoan;

/**
 * Created by Moiz Ahmed on 11/16/2015
 */
public class new_qarz extends Activity {
    String[] labels;
    int lang;

    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;

    private TextView CNIC;
    private TextView landNumber;
    private TextView amount;
    private TextView date;

    Spinner fname;
    Spinner land;

    String cnic = "";
    String landNo = "";

    Cursor c;
    Cursor d;
    SQLiteDatabase db;

    private Button submit;
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_qarz);
        setLanguage();



        initUI();
        spinValues();
        setLabels();
        startListeners();

    }

    public void spinValues(){

        GetAdapters adapters = new GetAdapters(this);
        fname.setAdapter(adapters.getFarmerArray());
        land.setAdapter(adapters.getLandArray());


    }
    private void startListeners() {
        submit.setOnClickListener(new LoanButtonListner());
        refresh.setOnClickListener(new LoanButtonListner());

    }
    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozqarz);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozqarz);
        }

    }

    private void setLabels() {
        CNIC.setText(labels[0]);
        landNumber.setText(labels[1]);
        amount.setText(labels[2]);
        date.setText(labels[3]);
    }

    private void initUI() {
        CNIC= (TextView)findViewById(R.id.tv_loan_CNIC);
        landNumber = (TextView) findViewById(R.id.tv_loan_landNumber);
        amount = (TextView) findViewById(R.id.tv_loan_amount);
        date = (TextView) findViewById(R.id.tv_loan_date);


        fname = (Spinner) findViewById(R.id.spin_loan_name);
        land = (Spinner) findViewById(R.id.spin_loan_landNumber);

        v3= (EditText) findViewById(R.id.et_loan_amount);
        v4= (EditText) findViewById(R.id.et_loan_date);




        submit = (Button) findViewById(R.id.btn_submit);
        refresh =(Button) findViewById(R.id.refresh);

    }
    private void setLoanObject() {
        ModelLoan modelLoan = new ModelLoan();

        modelLoan.setName(fname.getSelectedItem().toString());
        modelLoan.setLandNumber(land.getSelectedItem().toString());
        modelLoan.setAmount(v3.getText().toString());
        modelLoan.setDate(v4.getText().toString());

        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertLoanToDb(modelLoan);

    }
    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_qarz.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();

    }

    public boolean emptyCheck(){
        String expense="";
        expense = v3.getText().toString();
        String date="";
        date = v4.getText().toString();

        if (expense.equals("")) {
            Toast.makeText(this, "قرض کا خرچہ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }if (date.equals("")) {
            Toast.makeText(this, "قرض تاریخ خالی ہے", Toast.LENGTH_SHORT).show();
            return false;
        }else
            return true;


    }
    private class LoanButtonListner implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    boolean empty = emptyCheck();
                    if(empty == true ) {
                        setLoanObject();
                        showDialogMessage();
                    }
                    break;
                case R.id.refresh:
                    Intent qarz = new Intent(getApplicationContext(), com.example.moizahmed.test1.Screens.new_qarz.class);
                    startActivity(qarz);
                    finish();
                    break;

            }
        }
    }


}
