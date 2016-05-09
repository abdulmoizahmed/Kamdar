package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import com.example.moizahmed.test1.R;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;

import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelMedicine;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.NumberFormat;
import java.util.Calendar;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_dawai extends Activity  implements DatePickerDialog.OnDateSetListener{
    String[] labels;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private TextView v5;

    private FloatLabel ID;
    private FloatLabel name;
    private FloatLabel company;
    private FloatLabel price;
    private TextView date;

    String current;

    String error;
    String selectError;

    String notunique;



    private Button submit;
    DataBaseHelper dbObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_dawai);
        setLanguage();
        initUI();
        setLabels();
        startListeners();

    }

    private void setFaslObject() {
        ModelMedicine modelMedicine = new ModelMedicine();
        modelMedicine.setID(v1.getText().toString());
        modelMedicine.setName(v2.getText().toString());
        modelMedicine.setCompany(v3.getText().toString());
        modelMedicine.setExpense(v4.getText().toString());
        modelMedicine.setDate(v5.getText().toString());
        dbObject.insertMedicineToDb(modelMedicine);

    }

    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_dawai.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    private void startListeners() {
        submit.setOnClickListener(new DawaiButtonListener());
        v5.setOnClickListener(new DawaiButtonListener());
        v4.addTextChangedListener(new mWatcher());


    }

    private void initUI() {
         dbObject = new DataBaseHelper(getApplicationContext());


        error =getResources().getString(R.string.empty);
        selectError =getResources().getString(R.string.dialog_title);
        notunique =getResources().getString(R.string.not_unique);


        ID= (FloatLabel) findViewById(R.id.et_medicine_ID);
        name= (FloatLabel) findViewById(R.id.et_medicine_name);
        company= (FloatLabel) findViewById(R.id.et_medicine_company);
        price= (FloatLabel) findViewById(R.id.et_medicine_expense);
        date= (TextView) findViewById(R.id.txt_date);

        v1 = ID.getEditText();
        v2 = name.getEditText();
        v3 = company.getEditText();
        v4 = price.getEditText();
        v5= (TextView) findViewById(R.id.et_medicine_date);

        submit =(Button) findViewById(R.id.btn_submit);


    }

    private void setLabels() {
        ID.setLabel(labels[0]);
        name.setLabel(labels[1]);
        company.setLabel(labels[2]);
        price.setLabel(labels[3]);
        date.setText(labels[4]);

    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputDawai);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputDawai);
        }

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        v5.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year);
    }


    private class DawaiButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    validateInputs();
                        //showDialogMessage();
                    break;
                case R.id.et_medicine_date :
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            new_dawai.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                    break;

            }
        }
    }

    private void validateInputs() {
        Cursor cursor =  dbObject.retrieveMedicineID(v1.getText().toString());

         if(v1.getText().toString().isEmpty())
        {
            v1.setError(error);
            v1.requestFocus();
        }
        else if(cursor.getCount()>0)
        {
            v1.setError(notunique);
            v1.requestFocus();
        }

        else if(v2.getText().toString().isEmpty())
        {
            v2.setError(error);
            v2.requestFocus();
        }
        else if(v3.getText().toString().isEmpty())
        {
            v3.setError(error);
            v3.requestFocus();
        }
        else if(v4.getText().toString().isEmpty())
        {
            v4.setError(error);
            v4.requestFocus();
        }
        else if(v5.getText().toString().equals(selectError))
        {
            v5.setError(error);
            v5.requestFocus();
        }
        else
        {
            setFaslObject();
            Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_SHORT).show();

        }
    }

    private class mWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (!s.toString().equals(current)) {
                v4.removeTextChangedListener(this);

                String replaceable = String.format("[%s,.\\s]", NumberFormat.getCurrencyInstance().getCurrency().getSymbol());
                String cleanString = s.toString().replaceAll(replaceable, "");

                double parsed;
                try {
                    parsed = Double.parseDouble(cleanString);
                } catch (NumberFormatException e) {
                    parsed = 0.00;
                }
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                formatter.setMaximumFractionDigits(0);
                String formatted = formatter.format((parsed));

                current = formatted;
                v4.setText(formatted);
                v4.setSelection(formatted.length());
                v4.addTextChangedListener(this);
            }


        }
    }
}
