package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moizahmed.test1.Model.DataBaseStarter;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelKhad;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_khad extends Activity {
    private String[] labels;
    private TextView number;
    private TextView owner;
    private TextView dimension ;
    private TextView place;
    private TextView expense1;
    private TextView date1;
    private EditText va;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private EditText v5;
    private Button refresh;
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
        DataBaseStarter dbObject = new DataBaseStarter(getApplicationContext());
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

    private void initUi() {
         number= (TextView)findViewById(R.id.ferNum);
         owner = (TextView) findViewById(R.id.textView50);
         dimension = (TextView) findViewById(R.id.textView51);
         place = (TextView) findViewById(R.id.textView52);
         expense1 = (TextView) findViewById(R.id.textView53);
         date1 = (TextView) findViewById(R.id.textView54);
         va= (EditText) findViewById(R.id.ferNumb);
         v1= (EditText) findViewById(R.id.editText36);
         v2= (EditText) findViewById(R.id.editText37);
         v3= (EditText) findViewById(R.id.editText38);
         v4= (EditText) findViewById(R.id.editText39);
         v5= (EditText) findViewById(R.id.editText40);
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

    private class KhadButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    setKhadObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("new_khad");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }
}
