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
import com.example.moizahmed.test1.Model.ModelLand;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_land extends Activity {
    private String[] labels;
    private TextView number;
    private TextView owner;
    private TextView dimension;
    private TextView place;
    private EditText v1;
    private EditText v2;
    private EditText v3;
    private EditText v4;
    private Button submit;
    private Button refresh;

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
        number.setText(labels[0]);
        owner.setText(labels[1]);
        dimension.setText(labels[2]);
        place.setText(labels[3]);


    }

    private void initUI() {
         number= (TextView)findViewById(R.id.z_number);
         owner = (TextView) findViewById(R.id.z_owner);
         dimension = (TextView) findViewById(R.id.z_dimension);
         place = (TextView) findViewById(R.id.textView16);
         v1= (EditText) findViewById(R.id.landNumb);
         v2= (EditText) findViewById(R.id.ownerName);
         v3= (EditText) findViewById(R.id.dims);
         v4= (EditText) findViewById(R.id.editText12);
         submit = (Button) findViewById(R.id.btn_submit);
         refresh =(Button) findViewById(R.id.refresh);

    }

    private void startListeners() {
        submit.setOnClickListener(new KhadButtonListener());
        refresh.setOnClickListener(new KhadButtonListener());

    }
    private void setLandObject() {
        ModelLand modelLand = new ModelLand();
        modelLand.setLandNumber(v1.getText().toString());
        modelLand.setLandOwner(v2.getText().toString());
        modelLand.setDimensions(v3.getText().toString());
        modelLand.setLandLoc(v4.getText().toString());
        DataBaseHelper dbObject = new DataBaseHelper(getApplicationContext());
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
                    setLandObject();
                    showDialogMessage();
                    break;
                case R.id.refresh:
                    Intent menu = new Intent("new_land");
                    startActivity(menu);
                    finish();
                    break;

            }
        }
    }


}
