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

import com.example.moizahmed.test1.Model.DataBaseStarter;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelSeed;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_seed extends Activity {

    private String[] labels;
    private TextView number;
    private TextView owner;
    private TextView dimension;
    private TextView place ;
    private TextView expense1;
    private TextView date1;
    private EditText va;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private EditText v5;
    private Button submit;
    private Button refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newseed);
        setLanguage();
        initUI();
        setLabels();
        startListeners();
    }

    private void setLabels() {
        number.setText(labels[0]);
        owner.setText(labels[1]);
        dimension.setText(labels[2]);
        place.setText(labels[3]);
        expense1.setText(labels[4]);
        date1.setText(labels[5]);

    }

    private void initUI() {

         number= (TextView)findViewById(R.id.textView15);
         owner = (TextView) findViewById(R.id.textView61);
         dimension = (TextView) findViewById(R.id.textView46);
         place = (TextView) findViewById(R.id.textView47);
         expense1 = (TextView) findViewById(R.id.textView48);
         date1 = (TextView) findViewById(R.id.textView49);
         va= (EditText) findViewById(R.id.seedID);
         v1= (EditText) findViewById(R.id.editText31);
         v2= (EditText) findViewById(R.id.editText32);
         v3= (EditText) findViewById(R.id.editText33);
         v4= (EditText) findViewById(R.id.editText34);
         v5= (EditText) findViewById(R.id.editText35);
        refresh =(Button) findViewById(R.id.refresh);
        submit=(Button) findViewById(R.id.btn_submit);

    }

    private void setFaslObject() {
        ModelSeed modelSeed = new ModelSeed();
        modelSeed.setID(va.getText().toString());
        modelSeed.setName(v1.getText().toString());
        modelSeed.setCompany(v2.getText().toString());
        modelSeed.setQuantity(v3.getText().toString());
        modelSeed.setExpense(v4.getText().toString());
        modelSeed.setDate(v5.getText().toString());
        DataBaseStarter dbObject = new DataBaseStarter(getApplicationContext());
        dbObject.insertSeedToDb(modelSeed);

    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());
        refresh.setOnClickListener(new KhadButtonListener());


    }

    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_seed.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }



    public void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputseed);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputseed);
        }


    }
    private class KhadButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    setFaslObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("new_seed");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }


}
