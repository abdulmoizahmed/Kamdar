package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Moiz Ahmed on 10/19/2015.
 */
public class Delete extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_delete);



        Button hari,fasl;
        hari = (Button) findViewById(R.id.btn_deletehari);
        hari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.delete_haari);

            }
        });

        fasl = (Button) findViewById(R.id.btn_deletefasl);
        fasl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    setContentView(R.layout.delete_fasl);

            }
        });


        Button back;
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menu = new Intent(Delete.this,MainMenu.class);
                menu.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(menu);
                finish();
            }
        });

    }
}
