package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelFasl;
import com.iangclifton.android.floatlabel.FloatLabel;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_fasl extends Activity implements DatePickerDialog.OnDateSetListener {
    String[] labels;
    //private EditText v1;
    EditText v1;
    private EditText v2;
    private TextView v3;
    private TextView name;
    private TextView yearr;
    private TextView date;
    private Button submit;
    private Button refresh;
    FloatLabel floatLabel;
    FloatLabel floatLabe2;
    String error;
    String selectError;
    String unique;
    String notunique;
    DataBaseHelper dbObject;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_fasal);
        setLanguage();
        initUI();
        setLabels();
        startListeners();

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        v3.setText(""+year);

    }


    private void setFaslObject() {
        ModelFasl modelFasl = new ModelFasl();

        modelFasl.setCropName(v1.getText().toString());
        modelFasl.setSeason(v2.getText().toString());
        modelFasl.setYear(v3.getText().toString());

        dbObject.insertFaslToDb(modelFasl);

    }

    private void showDialogMessage() {
        Toast.makeText(new_fasl.this, R.string.success, Toast.LENGTH_SHORT).show();


    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());
        v3.setOnClickListener(new KhadButtonListener());

    }

    private void initUI() {
         floatLabel =(FloatLabel)findViewById(R.id.editText28);
        // v1= (EditText) findViewById(R.id.editText28);
         floatLabe2= (FloatLabel) findViewById(R.id.editText29);

         v3= (TextView) findViewById(R.id.editText30);

         date = (TextView) findViewById(R.id.txt_date);
         submit = (Button) findViewById(R.id.btn_submit);

        error =getResources().getString(R.string.empty);
        selectError =getResources().getString(R.string.dialog_title);
        notunique =getResources().getString(R.string.not_unique);

        v1 = floatLabel.getEditText();
        v2 = floatLabe2.getEditText();

        dbObject = new DataBaseHelper(getApplicationContext());

    }

    private void setLabels() {

        floatLabel.setLabel(labels[0]);
        floatLabe2.setLabel(labels[1]);
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
                    validateInput();
                    break;

                case R.id.editText30:
                    Calendar now = Calendar.getInstance();
                    DatePickerDialog dpd = DatePickerDialog.newInstance(
                            new_fasl.this,
                            now.get(Calendar.YEAR),
                            now.get(Calendar.MONTH),
                            now.get(Calendar.DAY_OF_MONTH)
                    );
                    dpd.show(getFragmentManager(), "Datepickerdialog");
                    break;

            }
        }
    }

    private void validateInput() {
       unique = v1.getText().toString();
       Cursor cursor =  dbObject.retrieveFasalDetails(unique);

        if(unique.isEmpty() )
        {
            v1.setError(error);

        }
        else if(cursor.getCount()>0)
        {
            v1.setError(notunique);
        }
        else if(v2.getText().toString().isEmpty())
        {
            v2.setError(error);
        }
        else if(v3.getText().toString().equals(selectError))
        {
            v3.setError(error);
        }
        else{
            setFaslObject();
            showDialogMessage();

        }


    }

}
