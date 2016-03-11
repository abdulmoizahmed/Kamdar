package com.example.moizahmed.test1.Screens;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Moiz Ahmed on 10/19/2015.
 */
public class Malomat extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_malomat);

        Button back;
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent menu = new Intent(Malomat.this,MainMenu.class);
                menu.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(menu);
                finish();
            }
        });

    }
}
