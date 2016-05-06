package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 11/16/2015.
 */
public class new_dawai extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_dawai);
        EditText name = (EditText)findViewById(R.id.input_name);
        name.setHint("مجھے");


    }
}
