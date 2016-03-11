package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.moizahmed.test1.Screens.MainMenu;

/**
 * Created by Moiz Ahmed on 11/12/2015.
 */
public class Report extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_main);Button back;
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu = new Intent(Report.this,MainMenu.class);
                menu.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(menu);
                finish();
            }
        });



    }
}
