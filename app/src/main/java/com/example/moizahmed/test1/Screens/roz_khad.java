package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

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

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class roz_khad extends Activity {
    private String[] labels;
    private int lang;
    private TextView number;
    private  TextView owner;
    private  TextView dimension;
    private TextView place;
    private  TextView expense1;
    private  TextView date1;
    private Spinner khadID;
    private Spinner landno;
    private Spinner company;
    private EditText quantity;
    private EditText date;
    private EditText expense;
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
        refresh =(Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent("roz_khad");
                menu.putExtra("language_id",lang);
                startActivity(menu);
                finish();


            }
        });


        submit=(Button) findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setKhadObject();
                showMessage();

            }
        });


    }

    private void setAdapters() {
        GetAdapters adapters = new GetAdapters(getApplicationContext());
        khadID.setAdapter(adapters.getKhadID());
        landno.setAdapter(adapters.getLandArray());
        company.setAdapter(adapters.getKhadCompany());
    }



    private void setLabels() {

        number.setText(labels[0]);
        dimension.setText(labels[2]);
        owner.setText(labels[1]);
        place.setText(labels[3]);
        expense1.setText(labels[4]);
        date1.setText(labels[5]);

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
        modelIssueFertilizer.setQuantity(quantity.getText().toString());
        modelIssueFertilizer.setExpense(expense.getText().toString());
        modelIssueFertilizer.setDate(date.getText().toString());
        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertIssueFertilizerToDb(modelIssueFertilizer);
    }




    private void initUI() {
        number= (TextView)findViewById(R.id.fertilizer_id);
        owner = (TextView) findViewById(R.id.landNum);
         dimension = (TextView) findViewById(R.id.company);
         place = (TextView) findViewById(R.id.quantity);
         expense1 = (TextView) findViewById(R.id.tv_fert_expense);
         date1 = (TextView) findViewById(R.id.tv_fert_date);

//        ID= (TextView)findViewById(R.id.fertilizer_id);
//        landnumber= (TextView)findViewById(R.id.landNum);
//        company = (TextView) findViewById(R.id.company);
//        quantity = (TextView) findViewById(R.id.quantity);
//        expense = (TextView) findViewById(R.id.tv_fert_expense);
//        date = (TextView) findViewById(R.id.tv_fert_date);

        khadID= (Spinner)findViewById(R.id.spin_ID);
         landno= (Spinner)findViewById(R.id.spin_landNum);
         company= (Spinner)findViewById(R.id.spin_company);
         quantity= (EditText) findViewById(R.id.et_fert_quantity);
         expense = (EditText) findViewById(R.id.et_fert_expense);
         date= (EditText) findViewById(R.id.et_fert_date);
        //


    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId()  == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozkhad);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozkhad);
        }

    }
}
