package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelFasl;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_fasl extends Activity {
    String[] labels;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private TextView name;
    private TextView yearr;
    private TextView date;
    private Button submit;
    private Button refresh;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_fasal);
        setLanguage();
        initUI();
        setLabels();
        startListeners();

    }

    private void setFaslObject() {
        ModelFasl modelFasl = new ModelFasl();
        modelFasl.setCropName(v1.getText().toString());
        modelFasl.setSeason(v2.getText().toString());
        modelFasl.setYear(v3.getText().toString());
        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
        dbObject.insertFaslToDb(modelFasl);

    }

    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_fasl.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());
        refresh.setOnClickListener(new KhadButtonListener());

    }

    private void initUI() {
         v1= (EditText) findViewById(R.id.editText28);
         v2= (EditText) findViewById(R.id.editText29);
         v3= (EditText) findViewById(R.id.editText30);
         name= (TextView)findViewById(R.id.txt_faslname);
         yearr = (TextView) findViewById(R.id.txt_season);
         date = (TextView) findViewById(R.id.txt_date);
         submit = (Button) findViewById(R.id.btn_submit);
         refresh =(Button) findViewById(R.id.refresh);


    }

    private void setLabels() {
        name.setText(labels[0]);
        yearr.setText(labels[1]);
        date.setText(labels[2]);

    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfasal);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfasal);
        }

    }


    private class KhadButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    setFaslObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("new_fasl");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }

}
