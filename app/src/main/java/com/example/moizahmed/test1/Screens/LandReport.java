package com.example.moizahmed.test1.Screens;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.moizahmed.test1.R;
import com.example.moizahmed.test1.Model.ModelLandReport;

public class LandReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_report);

        getReport();
    }
    public void getReport(){


        ModelLandReport modelLandReport = new ModelLandReport();
        Cursor c1 = modelLandReport.getLandNumb(getApplicationContext());
        int landrec = c1.getCount();

        String landNumber = "";

        //Cursor c2 = modelSurveyReport.getSurveyReport(getApplicationContext(),);



        // Toast.makeText(LandReport.this, "Hello Umair :) " + landrec, Toast.LENGTH_SHORT).show();

        TextView tv = (TextView) findViewById(R.id.col1);
        TextView tv2 = (TextView) findViewById(R.id.col2);
        TextView tv3= (TextView) findViewById(R.id.col3);
        TextView tv4 = (TextView) findViewById(R.id.col4);
        TextView tv5 = (TextView) findViewById(R.id.col5);
        TextView tv6 = (TextView) findViewById(R.id.col6);

        TextView r2tv = (TextView) findViewById(R.id.r2col1);
        TextView r2tv2 = (TextView) findViewById(R.id.r2col2);
        TextView r2tv3= (TextView) findViewById(R.id.r2col3);
        TextView r2tv4 = (TextView) findViewById(R.id.r2col4);
        TextView r2tv5 = (TextView) findViewById(R.id.r2col5);
        TextView r2tv6 = (TextView) findViewById(R.id.r2col6);



        StringBuilder col6 = new StringBuilder("زمین نمبر");
        StringBuilder col5 = new StringBuilder("ملکیت");
        StringBuilder col4 = new StringBuilder("فصل کا نام");
        StringBuilder col3 = new StringBuilder("رقبہ زمین");
        StringBuilder col2 = new StringBuilder("زمین ایڈریس");
        StringBuilder col1 = new StringBuilder("لگنے کی تاریخ");

        StringBuilder r2col1 = new StringBuilder("");
        StringBuilder r2col2 = new StringBuilder("");
        StringBuilder r2col3 = new StringBuilder("");
        StringBuilder r2col4 = new StringBuilder("");
        StringBuilder r2col5 = new StringBuilder("");
        StringBuilder r2col6 = new StringBuilder("");


        tv.setText(col1);
        tv2.setText(col2);
        tv3.setText(col3);
        tv4.setText(col4);
        tv5.setText(col5);
        tv6.setText(col6);

        while(c1.moveToNext()) {

            String c = c1.getString(0);
            r2col6.append(c+"\n");




            Cursor c2 = modelLandReport.getLandReport(getApplicationContext(), c);
            int records = c2.getCount();
            //Toast.makeText(LandReport.this, "records: in " + c + " are " + records, Toast.LENGTH_SHORT).show();

            c2.moveToFirst();
            if(records >0) {

                do {

                    String b = c2.getString(1);
                    String d = c2.getString(6);
                    String e = c2.getString(2);
                    String f = c2.getString(3);
                    String g = c2.getString(14);

                    r2col5.append(b + "\n");
                    r2col4.append(d + "\n");
                    r2col3.append(e + "\n");
                    r2col2.append(f + "\n");
                    r2col1.append(g + "\n");
                    r2col6.append("\n");
                } while (c2.moveToNext());
            }

            r2col5.append("\n");
            r2col4.append("\n");
            r2col3.append("\n");
            r2col2.append("\n");
            r2col1.append("\n");




        }


        r2tv.setText(r2col1);
        r2tv2.setText(r2col2);
        r2tv3.setText(r2col3);
        r2tv4.setText(r2col4);
        r2tv5.setText(r2col5);
        r2tv6.setText(r2col6);

    }

}
