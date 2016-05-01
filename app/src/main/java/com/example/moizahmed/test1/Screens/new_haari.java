package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelFarmer;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_haari extends Activity {

    private String[] labels;
    private int lang;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private  EditText v4;
    private  EditText v5;
    private  EditText v6;
    private  EditText v7;
    private  EditText v8;
    private  Spinner v9;
    private  Spinner v10;
    private  Spinner v11;
    private  TextView number;
    private  TextView owner;
    private TextView dimension;
    private TextView agreement;
    private Button submit;
    private Button refresh;

    // Umair Younas DB Creation And integration.
    String name;
    String CNIC;
    String address;
    String phone;
    String date;
    String conditions;
    String expirience;
    String salary;

    Cursor c;
    Cursor d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_haari);
        setLanguage();
        init();
        setLabels();
        initAdapters();
        startListener();
    }

    private void initAdapters() {
        GetAdapters adapter = new GetAdapters(this);
        v9.setAdapter(adapter.getLandArray());
        v10.setAdapter(adapter.getFasalArraySpinner());
    }

    private void startListener() {
        submit.setOnClickListener(new HaariButtonListener());
        refresh.setOnClickListener(new HaariButtonListener());
    }

    private void setLabels() {
        v1.setHint(labels[0]);
        number.setText(labels[1]);
        owner.setText(labels[2]);
        dimension.setText(labels[3]);
        v3.setHint(labels[4]);
        v4.setHint(labels[5]);
        v5.setHint(labels[6]);
        v6.setHint(labels[7]);
        agreement.setText(labels[8]);
        v7.setHint(labels[9]);
        v8.setHint(labels[10]);

    }

    private void init() {
         v1= (EditText) findViewById(R.id.hari_name);
         v2= (EditText) findViewById(R.id.editText13);
         v3= (EditText) findViewById(R.id.hari_address);
         v4= (EditText) findViewById(R.id.hari_number);
         v5= (EditText) findViewById(R.id.hari_income);
         v6= (EditText) findViewById(R.id.hari_conds);
         v7= (EditText) findViewById(R.id.hari_);
         v8= (EditText) findViewById(R.id.hari_experince);
         v9= (Spinner) findViewById(R.id.SpinnerLandNumber);
         v10= (Spinner) findViewById(R.id.SpinnerfaslNumber);
         v11= (Spinner) findViewById(R.id.SpinnerFeedbackType);
         number= (TextView)findViewById(R.id.land_number);
         owner = (TextView) findViewById(R.id.fasal_number);
         dimension = (TextView) findViewById(R.id.date);
         agreement = (TextView) findViewById(R.id.agreement);

         submit = (Button) findViewById(R.id.btn_submit);
         refresh =(Button) findViewById(R.id.refresh);

    }


    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_haari.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();

    }

    private void setHaariObject() {
        ModelFarmer modelFarmer = new ModelFarmer();

        modelFarmer.setName(v1.getText().toString());
        modelFarmer.setDate(v2.getText().toString());
        modelFarmer.setAddress(v3.getText().toString());
        modelFarmer.setPhone(v4.getText().toString());
        modelFarmer.setSalary(v5.getText().toString());
        modelFarmer.setConditions(v6.getText().toString());
        modelFarmer.setCNIC(v7.getText().toString());
        modelFarmer.setExperience(v8.getText().toString());
        modelFarmer.setLandNumber(v9.getSelectedItem().toString());
        modelFarmer.setCropName(v10.getSelectedItem().toString());
        modelFarmer.setContract(v11.getSelectedItem().toString());
        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertFarmerToDb(modelFarmer);
    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputHari);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputHari);
        }
    }

    private class HaariButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    setHaariObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("new_haari");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }


}
