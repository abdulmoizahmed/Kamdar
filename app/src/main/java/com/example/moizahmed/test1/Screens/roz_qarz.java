package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelLoan;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.NumberFormat;
import java.util.Calendar;

import fr.ganfra.materialspinner.MaterialSpinner;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015
 */
public class roz_qarz extends Activity  implements DatePickerDialog.OnDateSetListener  {
    String[] labels;
    int lang;

    private EditText v1;
    private EditText v2;
    private EditText v3;
    private TextView v4;

    private FloatLabel CNIC;
    private FloatLabel landNumber;
    private FloatLabel amount;
    private TextView date;

    MaterialSpinner fname;
    MaterialSpinner land;

    String current = "";
    String landNo = "";

    Cursor c;
    Cursor d;
    SQLiteDatabase db;

    private Button submit;
    private Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_qarz);
        setLanguage();



        initUI();
        setAdapters();
        setLabels();
        startListeners();

    }

    public void setAdapters(){

        GetAdapters adapters = new GetAdapters(this);
        fname.setAdapter(adapters.getFarmerArray());
        land.setAdapter(adapters.getLandArray());

    }
    private void startListeners() {
        submit.setOnClickListener(new LoanButtonListner());
        v4.setOnClickListener(new LoanButtonListner());
        v3.addTextChangedListener(new mWatcher());

    }
    public void setLanguage() {


        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozqarz);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozqarz);
        }

    }

    private void setLabels() {
        fname.setFloatingLabelText(labels[0]);
        land.setFloatingLabelText(labels[1]);
        amount.setLabel(labels[2]);
        date.setText(labels[3]);
    }

    private void initUI() {


        date = (TextView) findViewById(R.id.tv_loan_date);


        fname = (MaterialSpinner) findViewById(R.id.spin_loan_name);
        land = (MaterialSpinner) findViewById(R.id.spin_loan_landNumber);
        amount =  (FloatLabel) findViewById(R.id.et_loan_amount);
        v4= (TextView) findViewById(R.id.et_loan_date);
        v3= amount.getEditText();




        submit = (Button) findViewById(R.id.btn_submit);


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
        AlertDialog alertDialog = new AlertDialog.Builder(roz_qarz.this).create();
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

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        v4.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year);
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
                case R.id.et_loan_date:
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            roz_qarz.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                    break;


            }
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
                v3.removeTextChangedListener(this);

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
                v3.setText(formatted);
                v3.setSelection(formatted.length());
                v3.addTextChangedListener(this);
            }
        }
    }
}
