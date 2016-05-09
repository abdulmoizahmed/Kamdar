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
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelKhad;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.NumberFormat;
import java.util.Calendar;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_khad extends Activity implements DatePickerDialog.OnDateSetListener{
    private String[] labels;
    private FloatLabel number;
    private FloatLabel owner;
    private FloatLabel dimension ;
    private FloatLabel place;
    private FloatLabel expense1;
    private TextView date1;
    private EditText va;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private TextView v5;
    DataBaseHelper dbObject;

    String error;
    String selectError;

    String notunique;
    String current;


    private Button submit;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newfertilizer);
        setLanguage();
        initUi();
        setLabels();
        startListeners();
    }


    private void setKhadObject() {
        ModelKhad modelKhad = new ModelKhad();
        modelKhad.setID(va.getText().toString());
        modelKhad.setName(v1.getText().toString());
        modelKhad.setCompany(v2.getText().toString());
        modelKhad.setQuantity(v3.getText().toString());
        modelKhad.setExpense(v4.getText().toString());
        modelKhad.setDate(v5.getText().toString());
        dbObject.insertKhadToDb(modelKhad);

    }

    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_khad.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();

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
        place.setLabel(labels[3]);
        expense1.setLabel(labels[4]);
        date1.setText(labels[5]);

    }

    private void initUi() {
         number= (FloatLabel) findViewById(R.id.ferNumb);
         owner= (FloatLabel) findViewById(R.id.editText36);
         dimension= (FloatLabel) findViewById(R.id.editText37);
         place= (FloatLabel) findViewById(R.id.editText38);
         expense1= (FloatLabel) findViewById(R.id.editText39);
         date1= (TextView) findViewById(R.id.txt_date);

         dbObject = new DataBaseHelper(getApplicationContext());


        va = number.getEditText();
        v1 = owner.getEditText();
        v2 = dimension.getEditText();
        v3= place.getEditText();
        v4= expense1.getEditText();
        v5= (TextView) findViewById(R.id.editText40);


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

    private class KhadButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    validateInputs();
                   // showDialogMessage();
                    break;
                case R.id.editText40:

                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            new_khad.this,
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
        Cursor cursor =  dbObject.retrieveFertilizerIDD(va.getText().toString());


        if(va.getText().toString().isEmpty())
        {
            va.setError(error);
            va.requestFocus();
        }
        else if(cursor.getCount()>0)
        {
            va.setError(notunique);
            va.requestFocus();
        }
       else if(v1.getText().toString().isEmpty())
        {
            v1.setError(error);
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
            setKhadObject();
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
