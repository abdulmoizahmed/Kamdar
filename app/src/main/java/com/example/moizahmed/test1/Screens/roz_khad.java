package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moizahmed.test1.Model.DataBaseStarter;
import com.example.moizahmed.test1.Model.ModelKhad;

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
    private EditText va;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private EditText v5;
 //   public ModelKhad modelKhad;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roz_fertilizer);
        Bundle extras = getIntent().getExtras();
        lang = extras.getInt("language_id");
        setLanguage();
        initUI();
        setLabels();




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

    private void setLabels() {

        number.setText(labels[0]);
        dimension.setText(labels[2]);
        owner.setText(labels[1]);
        place.setText(labels[3]);
        expense1.setText(labels[4]);

    }

    private void showMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(roz_khad.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    private void setKhadObject() {

//        ModelKhad modelKhad = new ModelKhad();
//        modelKhad.setID(va.getText().toString());
//        modelKhad.setName(v1.getText().toString());
//        modelKhad.setCompany(v2.getText().toString());
//        modelKhad.setQuantity(v3.getText().toString());
//        modelKhad.setExpense(v4.getText().toString());
//        modelKhad.setDate(v5.getText().toString());
//        modelKhad.saveObject(modelKhad);
    }




    private void initUI() {
        number= (TextView)findViewById(R.id.textView27);
        owner = (TextView) findViewById(R.id.textView28);
         dimension = (TextView) findViewById(R.id.textView29);
         place = (TextView) findViewById(R.id.textView30);
         expense1 = (TextView) findViewById(R.id.textView31);
          va= (EditText) findViewById(R.id.ferNumb);
          v1= (EditText) findViewById(R.id.editText36);
          v2= (EditText) findViewById(R.id.editText37);
          v3= (EditText) findViewById(R.id.editText38);
          v4= (EditText) findViewById(R.id.editText39);
          v5= (EditText) findViewById(R.id.editText40);



    }

    public void setLanguage() {
        if (lang == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozkhad);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozkhad);
        }

    }
}
