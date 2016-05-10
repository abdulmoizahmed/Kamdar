package com.example.moizahmed.test1.Screens;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.ModelAnnualFaslReport;
import com.example.moizahmed.test1.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FaslAnnualReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasl_annual_report);
        getReport();
    }

    public void getReport() {

        int Total = 0;


        ModelAnnualFaslReport modelAnnualFaslReport = new ModelAnnualFaslReport();
        Cursor c1 = modelAnnualFaslReport.getCropName(getApplicationContext());
        int cropNum = c1.getCount();


        TextView tv = (TextView) findViewById(R.id.col1);
        TextView tv2 = (TextView) findViewById(R.id.col2);
        TextView tv3 = (TextView) findViewById(R.id.col3);
        TextView tv4= (TextView) findViewById(R.id.col4);
        TextView tv5 = (TextView) findViewById(R.id.col5);
        TextView tv6 = (TextView) findViewById(R.id.col6);

        TextView r2tv = (TextView) findViewById(R.id.r2col1);
        TextView r2tv2 = (TextView) findViewById(R.id.r2col2);
        TextView r2tv3 = (TextView) findViewById(R.id.r2col3);
        TextView r2tv4= (TextView) findViewById(R.id.r2col4);
        TextView r2tv5 = (TextView) findViewById(R.id.r2col5);
        TextView r2tv6 = (TextView) findViewById(R.id.r2col6);

        StringBuilder col6 = new StringBuilder("فصل");

        StringBuilder col5 = new StringBuilder("مشین نمبر");
        StringBuilder col4 = new StringBuilder("زمین نمبر");
        StringBuilder col3 = new StringBuilder("وقت");
        StringBuilder col2 = new StringBuilder("خرچ");
        StringBuilder col1 = new StringBuilder("تاریخ");

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

        Calendar cal = Calendar.getInstance();
        System.out.println("Current time => " + cal.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = df.format(cal.getTime());


        while(c1.moveToNext()) {

            String c = c1.getString(0);
            r2col6.append(c + "\n");

            Toast.makeText(FaslAnnualReport.this, "records: in " + c + " are " + cropNum, Toast.LENGTH_SHORT).show();

            Cursor c2 = modelAnnualFaslReport.getFaslAnnualReportMachine(getApplicationContext(), c, date1);
            int records = c2.getCount();


           // Toast.makeText(FaslAnnualReport.this, "tax sum: in " + c + " is " + sum, Toast.LENGTH_SHORT).show();

            c2.moveToFirst();

            if (records > 0) {
                do {
                    String taxID = c2.getString(0);
                    String type = c2.getString(2);
                    String tComp = c2.getString(3);
                    String tExp = c2.getString(4);
                    String tDate = c2.getString(5);

                    r2col5.append(taxID + "\n");
                    r2col4.append(type + "\n");
                    r2col3.append(tComp + "\n");
                    r2col2.append(tExp + "\n");
                    r2col1.append(tDate + "\n");
                    r2col6.append("\n");
                } while (c2.moveToNext());
            }
            r2col5.append("\n");
            r2col4.append("\n");
            r2col3.append("\n");
            r2col2.append("\n");
            r2col1.append("\n");
            r2col6.append("\n");

        }
    }

}
