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

import com.example.moizahmed.test1.Model.DataBaseStarter;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelMachine;
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

    private TextView number;
    private TextView owner;
    private  TextView dimension;
    private TextView place;
    private TextView expense1;
    private TextView date1;
    private Button submit;
    private Button refresh;
    private EditText v1,v2,v3,v4,v5;
    private Spinner TypeSpinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newmachine);
        setLanguage();
        initUI();
        setLabels();
        startListeners();

    }

    private void setMachineObject() {
        ModelMachine modelMachine = new ModelMachine();
        modelMachine.setModelNumber(v1.getText().toString());
        modelMachine.setName(v2.getText().toString());
        modelMachine.setCompany(v3.getText().toString());
        modelMachine.setExpense(v4.getText().toString());
        modelMachine.setDate(v5.getText().toString());
        modelMachine.setOwner(TypeSpinner.getSelectedItem().toString());
        DataBaseStarter dbObject = new DataBaseStarter(getApplicationContext());
        dbObject.insertMachineToDb(modelMachine);

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
        expense1.setText(labels[4]);
        date1.setText(labels[5]);

    }

    private void initUI() {
         number= (TextView)findViewById(R.id.textView18);
         owner = (TextView) findViewById(R.id.textView17);
         dimension = (TextView) findViewById(R.id.textView20);
         place = (TextView) findViewById(R.id.textView59);
         expense1 = (TextView) findViewById(R.id.textView21);
         date1 = (TextView) findViewById(R.id.textView22);

         v1= (EditText) findViewById(R.id.modelNo);
         v2= (EditText) findViewById(R.id.editText15);
         v3= (EditText) findViewById(R.id.editText16);
         v4= (EditText) findViewById(R.id.editText17);
         v5= (EditText) findViewById(R.id.editText18);

        TypeSpinner=(Spinner) findViewById(R.id.spinnerType);


        refresh =(Button) findViewById(R.id.refresh);
        submit=(Button) findViewById(R.id.btn_submit);

    }

    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfertilizer);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfertilizer);
        }

    }

    private class KhadButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    setMachineObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("new_machine");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }



    private void showDialogMessage() {

        AlertDialog alertDialog = new AlertDialog.Builder(new_machine.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();

    }
}
