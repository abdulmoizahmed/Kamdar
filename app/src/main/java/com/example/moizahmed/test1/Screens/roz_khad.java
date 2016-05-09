package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelIssueFertilizer;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.NumberFormat;
import java.util.Calendar;

import fr.ganfra.materialspinner.MaterialSpinner;
import com.example.moizahmed.test1.R;
/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_khad extends Activity  implements DatePickerDialog.OnDateSetListener {
    private String[] labels;
    private int lang;
    private TextView number;
    private  TextView owner;
    private  TextView dimension;
    private TextView place;

    private  TextView date1;
    private MaterialSpinner khadID;
    private MaterialSpinner landno;
    private MaterialSpinner company;
    private FloatLabel quantity;
    private TextView date;
    private FloatLabel expense;
    String current;

    EditText quantity1,expense1;
 //   public ModelKhad modelKhad;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_fertilizer);
        setLanguage();
        initUI();
        setLabels();
        setAdapters();



        Button refresh,submit;


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setKhadObject();
                showMessage();

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        roz_khad.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");

            }
        });

        expense1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!s.toString().equals(current)) {
                    expense1.removeTextChangedListener(this);

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
                    expense1.setText(formatted);
                    expense1.setSelection(formatted.length());
                    expense1.addTextChangedListener(this);
                }
            }
        });


    }

    private void setAdapters() {
        GetAdapters adapters = new GetAdapters(getApplicationContext());
        khadID.setAdapter(adapters.getKhadID());
        landno.setAdapter(adapters.getLandArray());
        company.setAdapter(adapters.getKhadCompany());
    }





    private void showMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_khad.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    private void setKhadObject() {
        ModelIssueFertilizer modelIssueFertilizer = new ModelIssueFertilizer();
        modelIssueFertilizer.setID(khadID.getSelectedItem().toString());
        modelIssueFertilizer.setLandNumber(landno.getSelectedItem().toString());
        modelIssueFertilizer.setCompany(company.getSelectedItem().toString());
        modelIssueFertilizer.setQuantity(quantity1.getText().toString());
        modelIssueFertilizer.setExpense(expense1.getText().toString());
        modelIssueFertilizer.setDate(date.getText().toString());
        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertIssueFertilizerToDb(modelIssueFertilizer);
    }

    private void setLabels() {

        khadID.setFloatingLabelText(labels[0]);
        company.setFloatingLabelText(labels[2]);
        landno.setFloatingLabelText(labels[1]);
        quantity.setLabel(labels[3]);
        expense.setLabel(labels[4]);
        date1.setText(labels[5]);

    }


    private void initUI() {


         date1 = (TextView) findViewById(R.id.tv_fert_date);

         khadID= (MaterialSpinner)findViewById(R.id.spin_ID);
         landno= (MaterialSpinner)findViewById(R.id.spin_landNum);
         company= (MaterialSpinner)findViewById(R.id.spin_company);


         quantity= (FloatLabel) findViewById(R.id.et_fert_quantity);
         expense = (FloatLabel) findViewById(R.id.et_fert_expense);
         date= (TextView) findViewById(R.id.et_fert_date);
        //

        quantity1 = quantity.getEditText();
        expense1 = expense.getEditText();


    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId()  == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozkhad);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozkhad);
        }

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        date.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year);
    }
}
