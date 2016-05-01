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
import com.example.moizahmed.test1.Model.ModelIssueMachine;

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

    Cursor c;
    Cursor d;
    Cursor e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_machine);

        setLanguage();

        spinValues();

        initUI();
        setLabels();
        startListeners();

    }



    public void spinValues(){


        db=openOrCreateDatabase("Khaatah", Context.MODE_PRIVATE, null); // open db...

        Cursor c = db.rawQuery("SELECT modelNumber FROM NewMachines;",null);
        Cursor d = db.rawQuery("SELECT landNumber FROM Land;",null);
        Cursor e = db.rawQuery("SELECT cropName FROM Crop;",null);

        final String[] arraySpinner1 = new String[c.getCount()];
        final String[] arraySpinner2 = new String[d.getCount()];
        final String[] arraySpinner3 = new String[e.getCount()];

        final Spinner v1= (Spinner) findViewById(R.id.spin_rozMachine_no);
        final Spinner v2= (Spinner) findViewById(R.id.spin_rozMachine_land);
        final Spinner v3= (Spinner) findViewById(R.id.spin_rozMachine_crop);

        int i=0;
        while(c.moveToNext())
        {
            arraySpinner1[i++] = c.getString(0);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner1);
        v1.setAdapter(adapter);

        int j=0;
        while(d.moveToNext())
        {
            arraySpinner2[j++] = d.getString(0);
        }


        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner2);
        v2.setAdapter(myadapter);
        int k=0;
        while(e.moveToNext())
        {
            arraySpinner3[k++] = e.getString(0);
        }


        ArrayAdapter<String> myadapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner3);
        v3.setAdapter(myadapter2);

        Spinner mySpinnerLand=(Spinner) findViewById(R.id.spin_rozMachine_no);
        final String ID = mySpinnerLand.getSelectedItem().toString();

        Spinner mySpinnerID=(Spinner) findViewById(R.id.spin_rozMachine_land);
        final String landNum = mySpinnerID.getSelectedItem().toString();

        Spinner mySpinnerCompany=(Spinner) findViewById(R.id.spin_rozMachine_crop);
        final String crop = mySpinnerCompany.getSelectedItem().toString();


        id = ID;
        landno = landNum;
        fasal = crop;
        db.close();


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

        v1= (EditText) findViewById(R.id.editText23);
        v2= (EditText) findViewById(R.id.editText24);
        v3= (EditText) findViewById(R.id.et_rozMachine_duration);

        submit = (Button) findViewById(R.id.btn_submit);
        refresh =(Button) findViewById(R.id.refresh);

    }

    private void startListeners() {
        submit.setOnClickListener(new IssueMachineButtonListener());
        refresh.setOnClickListener(new IssueMachineButtonListener());

    }
    private void setMachineObject() {
        ModelIssueMachine modelIssueMachine = new ModelIssueMachine();

        modelIssueMachine.setLandNumber(landno);
        modelIssueMachine.setModelNumber(id);
        modelIssueMachine.setCropName(fasal);
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
                case R.id.refresh:
                    Intent intent = new Intent(getApplicationContext(), com.example.moizahmed.test1.Screens.roz_machine.class);
                    startActivity(intent);
                    finish();
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
