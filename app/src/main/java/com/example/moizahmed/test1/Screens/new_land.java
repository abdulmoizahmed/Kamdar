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
import com.example.moizahmed.test1.Model.ModelLand;
import com.iangclifton.android.floatlabel.FloatLabel;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_land extends Activity {
    private String[] labels;
    private FloatLabel number;
    private FloatLabel owner;
    private FloatLabel dimension;
    private FloatLabel place;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private Button submit;
    DataBaseHelper dbObject;

    String error;
    String selectError;
    String notunique;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_newland);
        setLanguage();
        initUI();
        setLabels();
        startListeners();

    }

    private void setLabels() {
        number.setLabel(labels[0]);
        owner.setLabel(labels[1]);
        dimension.setLabel(labels[2]);
        place.setLabel(labels[3]);


    }


    private void initUI() {
         number= (FloatLabel) findViewById(R.id.landNumb);
         owner= (FloatLabel) findViewById(R.id.ownerName);
         dimension= (FloatLabel) findViewById(R.id.dims);
         place= (FloatLabel) findViewById(R.id.editText12);

        v1 = number.getEditText();
        v2 = owner.getEditText();
        v3 = dimension.getEditText();
        v4 = place.getEditText();
         submit = (Button) findViewById(R.id.btn_submit);

        error =getResources().getString(R.string.empty);
        selectError =getResources().getString(R.string.dialog_title);
        notunique =getResources().getString(R.string.not_unique);

      dbObject = new DataBaseHelper(getApplicationContext());

    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());

    }
    private void setLandObject() {
        ModelLand modelLand = new ModelLand();
        modelLand.setLandNumber(v1.getText().toString());
        modelLand.setLandOwner(v2.getText().toString());
        modelLand.setDimensions(v3.getText().toString());
        modelLand.setLandLoc(v4.getText().toString());
        dbObject.insertLandToDb(modelLand);
    }


    private void showDialogMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(new_land.this).create();
        alertDialog.setMessage("شکریہ! اندراج ہوگیا ہے۔");
        alertDialog.setIcon(R.drawable.logo1);
        alertDialog.show();
    }


    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_newland);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_newland);
        }
    }

    private class KhadButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_submit:
                    validateInputs();
                    break;


            }
        }
    }

    private void validateInputs() {
        Cursor cursor =  dbObject.retrieveLandDetails(v1.getText().toString());


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
        else
        {
            setLandObject();
            Toast.makeText(getApplicationContext(), R.string.success, Toast.LENGTH_SHORT).show();

        }


    }


}
