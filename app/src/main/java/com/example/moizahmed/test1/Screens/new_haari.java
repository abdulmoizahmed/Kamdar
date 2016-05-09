package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelFarmer;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

import fr.ganfra.materialspinner.MaterialSpinner;
import com.example.moizahmed.test1.R;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_haari extends Activity implements DatePickerDialog.OnDateSetListener {

    private String[] labels;

    private EditText v1;
    //private EditText v2;
    private EditText v3;
    private EditText v4;
    private EditText v5;
    private EditText v6;
    private EditText v7;
    private EditText v8;
    private MaterialSpinner v9;
    private MaterialSpinner v10;
    private MaterialSpinner v11;
    private FloatLabel f1;
    private TextView v2;
    private FloatLabel f3;
    private FloatLabel f4;
    private FloatLabel f5;
    private FloatLabel f6;
    private FloatLabel f7;
    private FloatLabel f8;


    private TextView mdate;
    private TextView owner;
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

    LinearLayout layout;

    String error;
    String selectError;
    String notunique;
    String fasalError;
    String landError;
    String contractError;
    String formatError;

    String current;



    String CnicRegex;

    DataBaseHelper dbObject;


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
        v2.setOnClickListener(new HaariButtonListener());
        v5.addTextChangedListener(new TextChanger());
        v7.addTextChangedListener(new CnicAdder());

    }

    private void setLabels() {
        f1.setLabel(labels[0]);
        v9.setFloatingLabelText(labels[1]);
        v10.setFloatingLabelText(labels[2]);
        mdate.setText(labels[3]);
        f3.setLabel(labels[4]);
        f4.setLabel(labels[5]);
        //f5.setLabel(labels[6]);
        f5.setLabel(labels[6]);
        f6.setLabel(labels[7]);
        v11.setFloatingLabelText(labels[8]);
        f7.setLabel(labels[9]);
        f8.setLabel(labels[10]);


    }

    private void init() {
        // Float Labels
        dbObject = new DataBaseHelper(getApplicationContext());


        f1 = (FloatLabel) findViewById(R.id.hari_name);
        v2 = (TextView) findViewById(R.id.editText13);
        mdate = (TextView) findViewById(R.id.txt_date);
        f3 = (FloatLabel) findViewById(R.id.hari_address);
        f4 = (FloatLabel) findViewById(R.id.hari_number);
        f5 = (FloatLabel) findViewById(R.id.hari_income);
        f6 = (FloatLabel) findViewById(R.id.hari_conds);
        f7 = (FloatLabel) findViewById(R.id.hari_);
        f8 = (FloatLabel) findViewById(R.id.hari_experince);

        //FloatLabelsEditTExt

        v1 = f1.getEditText();
        //v2 = f2.getEditText();
        v3 = f3.getEditText();
        v4 = f4.getEditText();
        v5 = f5.getEditText();
        v6 = f6.getEditText();
        v7 = f7.getEditText();
        v8 = f8.getEditText();

        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(2); //Filter to 2 characters
        v8.setFilters(filters);


        InputFilter[] filter = new InputFilter[1];
        filter[0] = new InputFilter.LengthFilter(15);
        v7.setFilters(filter);

        //spinners
        v9 = (MaterialSpinner) findViewById(R.id.SpinnerLandNumber);
        v10 = (MaterialSpinner) findViewById(R.id.SpinnerfaslNumber);
        v11 = (MaterialSpinner) findViewById(R.id.SpinnerFeedbackType);

        submit = (Button) findViewById(R.id.btn_submit);


        //InitError Messages
        error = getResources().getString(R.string.empty);
        selectError = getResources().getString(R.string.dialog_title);
        notunique = getResources().getString(R.string.not_unique);
        fasalError = getResources().getString(R.string.dialog_enter_fasal);
        landError = getResources().getString(R.string.dialog_enter_zamen);
        contractError = getResources().getString(R.string.dialog_enter_contract);
        formatError = getResources().getString(R.string.dialog_format_cnic);

        CnicRegex = "^[0-9+]{5}-[0-9+]{7}-[0-9]{1}$";

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
        dbObject.insertFarmerToDb(modelFarmer);
    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputHari);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputHari);
        }
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        v2.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year);

    }

    private class HaariButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_submit:
                    validateInputs();
                    // 0showDialogMessage();
                    break;
                case R.id.editText13:
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            new_haari.this,
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
        Cursor c = dbObject.retrieveFarmerCnic(v7.getText().toString());

        if (v1.getText().toString().isEmpty()) {
            v1.setError(error);
            v1.requestFocus();

        } else if (v9.getSelectedItem().toString().equals(landError)) {
            v9.setError(error);
            Toast.makeText(this, getResources().getString(R.string.emptyAbove), Toast.LENGTH_LONG).show();
            v9.requestFocus();
        } else if (v10.getSelectedItem().toString().equals(fasalError)) {
            v10.setError(error);
            Toast.makeText(this, getResources().getString(R.string.emptyAbove), Toast.LENGTH_LONG).show();
            v10.requestFocus();
        } else if (v3.getText().toString().isEmpty()) {
            v3.setError(error);
            Toast.makeText(this, getResources().getString(R.string.emptyAbove), Toast.LENGTH_LONG).show();
            v3.requestFocus();
        } else if (v4.getText().toString().isEmpty()) {
            v4.setError(error);
            v4.requestFocus();
        } else if (v5.getText().toString().isEmpty()) {
            v5.setError(error);
            v5.requestFocus();
        } else if (v6.getText().toString().isEmpty()) {
            v6.setError(error);
            v6.requestFocus();
        } else if (v11.getSelectedItem().toString().equals(contractError)) {
            v11.setError(error);
            Toast.makeText(this, getResources().getString(R.string.emptyAbove), Toast.LENGTH_LONG).show();
            v11.requestFocus();
        } else if (v7.getText().toString().isEmpty()) {
            v7.setError(error);
            v7.requestFocus();
        } else if ((v7.getText().toString().matches(CnicRegex) != true)) {
            String format = " (7-5902441-42000) ";
            v7.setError(formatError + format);
            v7.requestFocus();
        } else if (c.getCount() > 0) {
            v7.setError(notunique);
            v7.requestFocus();
        } else if (v8.getText().toString().isEmpty()) {
            v8.setError(error);
            Toast.makeText(this, getResources().getString(R.string.emptyAbove), Toast.LENGTH_LONG).show();
            v8.requestFocus();
        } else if (v2.getText().toString().equals(selectError)) {
            v2.setError(error);
            Toast.makeText(this, getResources().getString(R.string.emptyAbove), Toast.LENGTH_LONG).show();
            v2.requestFocus();
        } else {
            setHaariObject();
            Toast.makeText(this, R.string.success, Toast.LENGTH_SHORT).show();
        }


    }


    private class TextChanger implements TextWatcher {
        //Boolean isEdiging = false;
        //StringBuffer buf = new StringBuffer("");

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!s.toString().equals(current)) {
                v5.removeTextChangedListener(this);

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
                v5.setText(formatted);
                v5.setSelection(formatted.length());
                v5.addTextChangedListener(this);
            }
        }
    }

    private class CnicAdder implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

            if (s.length() == 5 || s.length() == 13) {
                s.append('-');
            }

        }
    }
}
