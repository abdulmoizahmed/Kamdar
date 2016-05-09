package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelMachine;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.NumberFormat;
import java.util.Calendar;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_machine extends Activity  implements DatePickerDialog.OnDateSetListener {


    String[] labels;
    int lang;

    // Umair Younas DB Creation And integration.
    String model;
    String name;
    String company;
    String expense;
    String date;

    private FloatLabel number;
    private FloatLabel owner;
    private  FloatLabel dimension;
    private FloatLabel place;
    private TextView expense1,v5;
    private FloatLabel date1;
    private Button submit;
    private EditText v1,v2,v3,v4,v6;
    private EditText quantity;
    String current;
    String error;
    String selectError;
    String notunique;
    DataBaseHelper dbObject;





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
        modelMachine.setQuantity(v6.getText().toString());
        modelMachine.setOwner("");
        dbObject.insertMachineToDb(modelMachine);

    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());
        v5.setOnClickListener(new KhadButtonListener());
        v4.addTextChangedListener(new mWatcher());
    }

    private void setLabels() {
        number.setLabel(labels[0]);
        owner.setLabel(labels[1]);
        dimension.setLabel(labels[2]);
        date1.setLabel(labels[3]);
        place.setLabel(labels[4]);
        expense1.setText(labels[5]);
    }

    private void initUI() {
         dbObject = new DataBaseHelper(getApplicationContext());



        number= (FloatLabel) findViewById(R.id.modelNo);
         owner= (FloatLabel) findViewById(R.id.editText15);
         dimension= (FloatLabel) findViewById(R.id.editText16);
         place= (FloatLabel) findViewById(R.id.editText17);
         expense1= (TextView) findViewById(R.id.txt_date);
         v5= (TextView) findViewById(R.id.editText18);
         date1= (FloatLabel) findViewById(R.id.quantity);

        v1 = number.getEditText();
        v2 = owner.getEditText();
        v3 = dimension.getEditText();
        v4 = place.getEditText();
        v6 = date1.getEditText();

        error =getResources().getString(R.string.empty);
        selectError =getResources().getString(R.string.dialog_title);
        notunique =getResources().getString(R.string.not_unique);




        submit=(Button) findViewById(R.id.btn_submit);

    }

    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfertilizer);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfertilizer);
        }

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        v5.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year);
    }

    private class KhadButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    validateInputs();

                    break;
                case R.id.editText18:
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            new_machine.this,
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

        Cursor cursor =  dbObject.retrieveMachineDetails(v1.getText().toString());

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
        else if(v6.getText().toString().isEmpty())
        {
            v6.setError(error);
            v6.requestFocus();
        }
        else
        {
            setMachineObject();
            Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_SHORT).show();

        }
    }


    private void showDialogMessage() {

        AlertDialog alertDialog = new AlertDialog.Builder(new_machine.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();

    }

    private class mWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
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

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
