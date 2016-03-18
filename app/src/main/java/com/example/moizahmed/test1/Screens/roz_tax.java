package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelRozTax;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_tax extends Activity {

    String[] labels;
    String ID;
    String company;
    String expense;

    private Button submit;
    private Button refresh;
    private TextView number;
    private TextView owner ;
    private TextView dimension;
    private TextView place;
    private TextView place1;
    private EditText v2;
    private EditText v3;
    private Spinner v4;
    private EditText v5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_taxashar);
        setLanguage();
        initUI();
        setLabels();
        initAdapters();
        startListeners();


       // final Spinner v1= (Spinner) findViewById(R.id.spinner5);


    }

    private void initAdapters() {
        //Set Adapters
        GetAdapters adapter = new GetAdapters(this);
        v4.setAdapter(adapter.getLandArray());

    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());
        refresh.setOnClickListener(new KhadButtonListener());

    }

    private void setLabels() {

        number.setText(labels[0]);
        owner.setText(labels[1]);
        dimension.setText(labels[2]);
        place.setText(labels[3]);
        place1.setText(labels[4]);
    }

    private void setLandObject() {
        ModelRozTax modelRozTax = new ModelRozTax();
        modelRozTax.setID(v2.getText().toString());
        modelRozTax.setCompany(v3.getText().toString());
        modelRozTax.setLandNum(v4.getSelectedItem().toString());
        modelRozTax.setExpense(v5.getText().toString());

        //  db.execSQL("INSERT INTO Tax VALUES('" + type.toString() + "','" + ID.toString() + "','" + company.toString() + "','" + landNum.toString() + "','" + expense.toString() + "');");


    }

    private void initUI() {
         number= (TextView)findViewById(R.id.textView23);
         owner = (TextView) findViewById(R.id.textView24);
         dimension = (TextView) findViewById(R.id.txt_tax_amount);
         place = (TextView) findViewById(R.id.textView25);
         place1 = (TextView) findViewById(R.id.textView26);
        v2= (EditText) findViewById(R.id.editText19);
         v3= (EditText) findViewById(R.id.taxComp);
         v4= (Spinner) findViewById(R.id.spinner6);
         v5= (EditText) findViewById(R.id.editText20);
         refresh =(Button) findViewById(R.id.refresh);
         submit = (Button) findViewById(R.id.btn_submit);

    }



    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_tax.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }


    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_roztax);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_roztax);
        }

    }

    private class KhadButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    setLandObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("roz_tax");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }



}
